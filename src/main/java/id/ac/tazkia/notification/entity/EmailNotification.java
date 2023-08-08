package id.ac.tazkia.notification.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data @Entity
public class EmailNotification extends BaseEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_notification")
    private Notification notification;

    @NotNull @NotEmpty
    private String subject;

    @NotNull @NotEmpty @Column(name = "mail_to")
    private String to;

    @NotNull @NotEmpty @Column(name = "mail_from")
    private String from;

    @NotNull @NotEmpty
    private String body;

    @NotNull
    private LocalDateTime sendTime = LocalDateTime.now();

    @NotNull
    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus = NotificationStatus.NEW;

    private String deliveryRemarks;
}
