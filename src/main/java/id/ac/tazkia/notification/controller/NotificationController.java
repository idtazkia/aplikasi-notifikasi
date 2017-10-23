package id.ac.tazkia.notification.controller;

import id.ac.tazkia.notification.dao.NotificationConfigurationDao;
import id.ac.tazkia.notification.dao.NotificationDao;
import id.ac.tazkia.notification.entity.Notification;
import id.ac.tazkia.notification.entity.NotificationConfiguration;
import id.ac.tazkia.notification.entity.NotificationVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController @Transactional
@RequestMapping("/api/client")
public class NotificationController {

    @Autowired private NotificationConfigurationDao notificationConfigurationDao;
    @Autowired private NotificationDao notificationDao;

    @PostMapping("/notification/{id}")
    public ResponseEntity create(
            @PathVariable("id") String configId,
            @RequestBody Map<String, String> data){

        Optional<NotificationConfiguration> config = notificationConfigurationDao.findById(configId);
        if(!config.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Notification notif = new Notification();
        notif.setNotificationConfiguration(config.get());
        for (String varName: data.keySet()) {
            NotificationVariable var = new NotificationVariable();
            var.setNotification(notif);
            notif.getVariables().add(var);
            var.setVariableName(varName);
            var.setVariableContent(data.get(varName));
        }
        notificationDao.save(notif);
        return ResponseEntity.ok().build();
    }
}
