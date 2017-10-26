package id.ac.tazkia.notification.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class EmailNotification {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_notification")
    private Notification notification;

    @NotNull @NotEmpty
    private String subject;

    @NotNull @NotEmpty @Column(name = "mail_to")
    private String to;

    @NotNull @NotEmpty
    private String body;

    @NotNull
    private LocalDateTime sendTime = LocalDateTime.now();

    @NotNull
    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus = NotificationStatus.NEW;

    private String deliveryRemarks;
}
