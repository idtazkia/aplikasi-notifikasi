package id.ac.tazkia.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import id.ac.tazkia.notification.dao.EmailNotificationDao;
import id.ac.tazkia.notification.dao.NotificationDao;
import id.ac.tazkia.notification.dao.SmsNotificationDao;
import id.ac.tazkia.notification.dto.NotificationRequest;
import id.ac.tazkia.notification.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

@Service @Transactional
public class NotificationService {

    @Autowired private SmsNotificationDao smsNotificationDao;
    @Autowired private EmailNotificationDao emailNotificationDao;
    @Autowired private NotificationDao notificationDao;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private MustacheFactory mustacheFactory;
    @Value("${template.email.basedir}") private String emailTemplateBasedir;

    public void create(NotificationConfiguration config, NotificationRequest request) throws JsonProcessingException {
        Notification notif = new Notification();
        notif.setNotificationConfiguration(config);
        notif.setNotificationData(objectMapper.writeValueAsString(request.getData()));
        notificationDao.save(notif);

        if(StringUtils.hasText(request.getMobile())){
            StringReader template = new StringReader(config.getTemplateSms().getTemplateContent());
            Mustache mustache = mustacheFactory.compile(template, "smstemplate");
            StringWriter output = new StringWriter();
            mustache.execute(output, request.getData());

            SmsNotification sms = new SmsNotification();
            sms.setNotification(notif);
            sms.setDestinationNumber(request.getMobile());
            sms.setNotificationStatus(NotificationStatus.NEW);
            sms.setContent(output.toString());
            smsNotificationDao.save(sms);
        }

        if (StringUtils.hasText(request.getEmail())) {
            StringReader subjectTemplate = new StringReader(config.getTemplateEmail().getSubject());
            Mustache mustacheSubject = mustacheFactory.compile(subjectTemplate, "smstemplate");
            StringWriter subject = new StringWriter();
            mustacheSubject.execute(subject, request.getData());

            String template = emailTemplateBasedir + File.separator +
                    config.getSender().getId() + File.separator +
                    config.getTemplateEmail().getFileLocation();
            Mustache mustacheBody = mustacheFactory.compile(template);
            StringWriter body = new StringWriter();
            mustacheBody.execute(body, request.getData());

            EmailNotification email = new EmailNotification();
            email.setNotificationStatus(NotificationStatus.NEW);
            email.setNotification(notif);
            email.setBody(body.toString());
            email.setSubject(subject.toString());
            email.setTo(request.getEmail());
            emailNotificationDao.save(email);
        }
    }
}
