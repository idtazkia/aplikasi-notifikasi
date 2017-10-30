package id.ac.tazkia.notification.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
