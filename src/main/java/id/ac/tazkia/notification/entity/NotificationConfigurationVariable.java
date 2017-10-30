package id.ac.tazkia.notification.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @Entity
public class NotificationConfigurationVariable extends BaseEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_notification_configuration")
    private NotificationConfiguration notificationConfiguration;

    @NotNull @NotEmpty
    private String variableName;

    private String description;
}
