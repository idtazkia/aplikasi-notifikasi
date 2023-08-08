package id.ac.tazkia.notification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data @Entity
public class TemplateSms extends BaseEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_sender")
    private Sender sender;

    @NotNull @NotEmpty
    private String description;

    @NotNull @NotEmpty
    private String templateContent;
}
