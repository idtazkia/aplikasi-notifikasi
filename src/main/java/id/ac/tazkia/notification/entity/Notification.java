package id.ac.tazkia.notification.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Notification {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
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

    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<NotificationVariable> variables = new HashSet<>();
}
