package id.ac.tazkia.notification.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.tazkia.notification.dao.EmailNotificationDao;
import id.ac.tazkia.notification.dao.SmsNotificationDao;
import id.ac.tazkia.notification.dto.EmailRequest;
import id.ac.tazkia.notification.dto.SmsRequest;
import id.ac.tazkia.notification.entity.EmailNotification;
import id.ac.tazkia.notification.entity.NotificationStatus;
import id.ac.tazkia.notification.entity.SmsNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    @Autowired private EmailNotificationDao emailNotificationDao;

    public void sendToKafka(String topic, String content){
        kafkaTemplate.send(topic, content);
    }

    @Scheduled(fixedRate = 10 * 1000)
    public void sendSmsNotification(){
        smsNotificationDao.findByNotificationStatusOrderBySendTime(NotificationStatus.NEW, PageRequest.of(0, 10))
                .iterator()
                .forEachRemaining(this::sendSmsNotification);
    }

    @Scheduled(fixedRate = 10 * 1000)
    public void sendEmailNotification(){
        emailNotificationDao.findByNotificationStatusOrderBySendTime(NotificationStatus.NEW, PageRequest.of(0, 10))
                .iterator()
                .forEachRemaining(this::sendEmailNotification);
    }

    private void sendEmailNotification(EmailNotification n){
        try {
            EmailRequest req = new EmailRequest();
            BeanUtils.copyProperties(n, req);
            String msgString = objectMapper.writeValueAsString(req);
            logger.debug("Sending [{}] to [{}]", msgString, emailTopic);
            sendToKafka(emailTopic, msgString);
            n.setNotificationStatus(NotificationStatus.SENT);
        } catch (Exception err){
            logger.error(err.getMessage(), err);
            n.setNotificationStatus(NotificationStatus.ERROR);
            n.setDeliveryRemarks(err.getMessage());
        } finally {
            emailNotificationDao.save(n);
        }
    }

    private void sendSmsNotification(SmsNotification n){
        try {
            SmsRequest req = new SmsRequest();
            BeanUtils.copyProperties(n, req);
            String msgString = objectMapper.writeValueAsString(req);
            logger.debug("Sending [{}] to [{}]", msgString, smsTopic);
            sendToKafka(smsTopic, msgString);
            n.setNotificationStatus(NotificationStatus.SENT);
        } catch (Exception err){
            logger.error(err.getMessage(), err);
            n.setNotificationStatus(NotificationStatus.ERROR);
            n.setDeliveryRemarks(err.getMessage());
        } finally {
            smsNotificationDao.save(n);
        }
    }

}
