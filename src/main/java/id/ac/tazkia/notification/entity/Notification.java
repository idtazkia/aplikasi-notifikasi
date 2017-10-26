package id.ac.tazkia.notification.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class Notification {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_notification_configuration")
    private NotificationConfiguration notificationConfiguration;

    @NotNull
    private LocalDateTime submitTime = LocalDateTime.now();

    @NotNull @NotEmpty
    private String notificationData;
}
