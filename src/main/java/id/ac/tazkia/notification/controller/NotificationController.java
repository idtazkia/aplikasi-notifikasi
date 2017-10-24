package id.ac.tazkia.notification.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.tazkia.notification.dao.NotificationConfigurationDao;
import id.ac.tazkia.notification.dao.NotificationDao;
import id.ac.tazkia.notification.dto.NotificationRequest;
import id.ac.tazkia.notification.entity.Notification;
import id.ac.tazkia.notification.entity.NotificationConfiguration;
import id.ac.tazkia.notification.entity.NotificationConfigurationVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController @Transactional
@RequestMapping("/api/client")
public class NotificationController {

    @Autowired private NotificationConfigurationDao notificationConfigurationDao;
    @Autowired private NotificationDao notificationDao;
    @Autowired private ObjectMapper objectMapper;

    @PostMapping("/notification/{id}")
    public ResponseEntity<Map<String, Object>> create(
            @PathVariable("id") String configId,
            @RequestBody NotificationRequest request){

        if (!StringUtils.hasText(request.getEmail()) || !StringUtils.hasText(request.getMobile())) {
            return generateErrorResponse("Email or Mobile must be present", HttpStatus.BAD_REQUEST);
        }

        Optional<NotificationConfiguration> config = notificationConfigurationDao.findById(configId);
        if(!config.isPresent()){
            return generateErrorResponse("Config " + configId + " not found", HttpStatus.NOT_FOUND);
        }

        List<String> missingVars = new ArrayList<>();
        for (NotificationConfigurationVariable v :config.get().getVariables()) {
            if (!request.getData().keySet().contains(v.getVariableName())) {
                missingVars.add(v.getVariableName());
            }
        }

        if(!missingVars.isEmpty()){
            return generateErrorResponse("Missing variables : " + missingVars.toString(), HttpStatus.BAD_REQUEST);
        }

        try {
            Notification notif = new Notification();
            notif.setNotificationConfiguration(config.get());
            notif.setNotificationContent(objectMapper.writeValueAsString(request.getData()));
            notificationDao.save(notif);
            return ResponseEntity.ok().build();
        } catch (JsonProcessingException e) {
            return generateErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private ResponseEntity<Map<String, Object>> generateErrorResponse(String message, HttpStatus badRequest) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("error", true);
        responseData.put("message", message);
        return new ResponseEntity<>(responseData, badRequest);
    }

}
