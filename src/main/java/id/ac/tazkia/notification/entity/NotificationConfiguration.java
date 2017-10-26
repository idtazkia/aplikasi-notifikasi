package id.ac.tazkia.notification.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "variables")
public class NotificationConfiguration {
    @Id
    @GeneratedValue(generator = "uuid")
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
    @NotEmpty
    private String configurationName;
    private String description;

    @OneToMany(mappedBy = "notificationConfiguration", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<NotificationConfigurationVariable> variables = new HashSet<>();

}
