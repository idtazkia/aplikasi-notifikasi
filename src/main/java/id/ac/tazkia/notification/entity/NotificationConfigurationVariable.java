package id.ac.tazkia.notification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data @Entity
public class NotificationConfigurationVariable extends BaseEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_notification_configuration")
    private NotificationConfiguration notificationConfiguration;

    @NotNull @NotEmpty
    private String variableName;

    private String description;

    @NotNull
    private Boolean required;
}
