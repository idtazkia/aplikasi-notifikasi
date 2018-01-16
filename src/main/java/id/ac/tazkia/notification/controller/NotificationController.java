package id.ac.tazkia.notification.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.tazkia.notification.dao.NotificationConfigurationDao;
import id.ac.tazkia.notification.dto.NotificationRequest;
import id.ac.tazkia.notification.entity.NotificationConfiguration;
import id.ac.tazkia.notification.entity.NotificationConfigurationVariable;
import id.ac.tazkia.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.*;

@RestController
@RequestMapping("/api/client")
public class NotificationController {



    @Autowired private NotificationConfigurationDao notificationConfigurationDao;
    @Autowired private NotificationService notificationService;
    @Autowired private ObjectMapper objectMapper;

    @PreAuthorize("hasAuthority('CREATE_NOTIFICATION')")
    @PostMapping("/notification/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> create(
            @PathVariable("id") String configId,
            @RequestBody NotificationRequest request){

        if (!StringUtils.hasText(request.getEmail()) || !StringUtils.hasText(request.getMobile())) {
            return Mono.just(generateErrorResponse("Email or Mobile must be present", HttpStatus.BAD_REQUEST));
        }

        Optional<NotificationConfiguration> config = notificationConfigurationDao.findById(configId);
        if(!config.isPresent()){
            return Mono.just(generateErrorResponse("Config " + configId + " not found", HttpStatus.NOT_FOUND));
        }

        List<String> missingVars = new ArrayList<>();
        for (NotificationConfigurationVariable v :config.get().getVariables()) {
            if (!request.getData().keySet().contains(v.getVariableName())) {
                missingVars.add(v.getVariableName());
            }
        }

        if(!missingVars.isEmpty()){
            return Mono.just(generateErrorResponse("Missing variables : " + missingVars.toString(), HttpStatus.BAD_REQUEST));
        }

        try {
            notificationService.create(config.get(), request);
            return Mono.just(ResponseEntity.ok().build());
        } catch (JsonProcessingException e) {
            return Mono.just(generateErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @GetMapping("/notification/{id}")
    public Mono<NotificationConfiguration> viewConfig(@PathVariable("id") String configId){
        return Mono.justOrEmpty(notificationConfigurationDao.findById(configId));
    }

    @GetMapping("/notification")
    public Mono<Iterable<NotificationConfiguration>> allConfig(){
        return Mono.justOrEmpty(notificationConfigurationDao.findAll());
    }

    private ResponseEntity<Map<String, Object>> generateErrorResponse(String message, HttpStatus badRequest) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("error", true);
        responseData.put("message", message);
        return new ResponseEntity<>(responseData, badRequest);
    }





}
