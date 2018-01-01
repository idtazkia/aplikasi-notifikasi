package id.ac.tazkia.notification.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.tazkia.notification.dao.NotificationConfigurationDao;
import id.ac.tazkia.notification.dto.NotificationRequest;
import id.ac.tazkia.notification.entity.NotificationConfiguration;
import id.ac.tazkia.notification.entity.NotificationConfigurationVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KafkaListeners {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListeners.class);

    @Autowired private NotificationService notificationService;
    @Autowired private NotificationConfigurationDao notificationConfigurationDao;
    @Autowired private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic.notification}", groupId = "${spring.kafka.consumer.group-id}")
    public void terimaNotifikasi(String message){
        try {
            NotificationRequest request = objectMapper.readValue(message, NotificationRequest.class);

            Optional<NotificationConfiguration> config
                    = notificationConfigurationDao.findById(request.getKonfigurasi());
            if(!config.isPresent()){
                throw new IllegalStateException("Konfigurasi Notifikasi "+request.getKonfigurasi()+" tidak tersedia");
            }

            NotificationConfiguration konfigurasi = config.get();

            List<String> missingVars = new ArrayList<>();
            for (NotificationConfigurationVariable v :config.get().getVariables()) {
                if (!request.getData().keySet().contains(v.getVariableName())) {
                    missingVars.add(v.getVariableName());
                }
            }

            if(!missingVars.isEmpty()){
                LOGGER.warn("Notifikasi tidak dapat dikirim, variabel berikut tidak terisi : [{}]", missingVars.toString());
                return;
            }

            notificationService.create(konfigurasi, request);
        } catch (Exception err){
            LOGGER.warn(err.getMessage(), err);
        }
    }
}

