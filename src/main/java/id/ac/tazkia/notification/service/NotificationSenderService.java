package id.ac.tazkia.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationSenderService {

    @Autowired private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.topic.name}") private String topic;

    public void sendToKafka(String topic, String content){
        kafkaTemplate.send(topic, content);
    }
}
