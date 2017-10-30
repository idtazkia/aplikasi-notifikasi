package id.ac.tazkia.notification.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "variables")
public class NotificationConfiguration  extends BaseEntity {
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
