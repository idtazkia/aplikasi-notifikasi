package id.ac.tazkia.notification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

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
