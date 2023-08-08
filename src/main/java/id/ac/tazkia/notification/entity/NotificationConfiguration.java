package id.ac.tazkia.notification.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


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
