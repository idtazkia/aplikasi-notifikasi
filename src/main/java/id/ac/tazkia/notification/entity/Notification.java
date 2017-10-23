package id.ac.tazkia.notification.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class Notification {
    @Id
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_sender")
    private Sender sender;

    @ManyToOne
    @JoinColumn(name = "id_template_email")
    private TemplateEmail templateEmail;

    @ManyToOne
    @JoinColumn(name = "id_template_sms")
    private TemplateSms templateSms;

    @NotNull
    private LocalDateTime submitTime = LocalDateTime.now();
    private LocalDateTime sendTime;

    @NotNull @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus = NotificationStatus.NEW;
}
