package id.ac.tazkia.notification.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data @Entity
public class TemplateEmail extends BaseEntity {
    @NotNull
    @ManyToOne @JoinColumn(name = "id_sender")
    private Sender sender;

    @NotNull
    private String subject;

    @NotNull
    private String description;

    @NotNull
    private String fileLocation;
}
