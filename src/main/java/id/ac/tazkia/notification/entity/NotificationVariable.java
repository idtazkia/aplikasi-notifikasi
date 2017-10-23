package id.ac.tazkia.notification.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(exclude="notification")
@Entity
public class NotificationVariable {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_notification")
    private Notification notification;

    @NotNull @NotEmpty
    private String variableName;
    @NotNull @NotEmpty
    private String variableContent;
}
