package id.ac.tazkia.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.tazkia.notification.dao.SmsNotificationDao;
import id.ac.tazkia.notification.entity.NotificationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NotificationSenderService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationSenderService.class);

    @Autowired private ObjectMapper objectMapper;
    @Autowired private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.topic.email}") private String emailTopic;
    @Value("${kafka.topic.sms}") private String smsTopic;

    @Autowired private SmsNotificationDao smsNotificationDao;

    public void sendToKafka(String topic, String content){
        kafkaTemplate.send(topic, content);
    }

    @Scheduled(fixedRate = 5 * 1000)
    public void sendSmsNotification(){
        smsNotificationDao.findByNotificationStatusOrderBySendTime(NotificationStatus.NEW, PageRequest.of(0, 10))
                .iterator()
                .forEachRemaining(sms -> {
                    try {
                        String smsMsg = objectMapper.writeValueAsString(sms);
                        logger.debug("Sending [{}] to [{}]", smsMsg, smsTopic);
                        kafkaTemplate.send(smsTopic, smsMsg);
                        sms.setNotificationStatus(NotificationStatus.SENT);
                    } catch (JsonProcessingException e) {
                        logger.warn(e.getMessage(), e);
                        sms.setNotificationStatus(NotificationStatus.ERROR);
                        sms.setDeliveryRemarks(e.getMessage());
                    }
                    smsNotificationDao.save(sms);
                });
    }
}
