package id.ac.tazkia.notification.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

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
