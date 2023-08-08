package id.ac.tazkia.notification.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data @Entity
public class Notification extends BaseEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_notification_configuration")
    private NotificationConfiguration notificationConfiguration;

    @NotNull
    private LocalDateTime submitTime = LocalDateTime.now();

    @NotNull @NotEmpty
    private String notificationData;
}
