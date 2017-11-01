package id.ac.tazkia.notification.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data @Entity
public class SmsNotification extends BaseEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_notification")
    private Notification notification;

    private String senderId;
    private String username;
    private String password;


    @NotNull @NotEmpty
    private String destinationNumber;

    @NotNull @NotEmpty
    private String content;

    @NotNull
    private LocalDateTime sendTime = LocalDateTime.now();

    @NotNull
    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus = NotificationStatus.NEW;

    private String deliveryRemarks;
}
