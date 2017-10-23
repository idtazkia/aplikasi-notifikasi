package id.ac.tazkia.notification.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class TemplateEmail {
    @Id
    private String id;

    @NotNull
    @ManyToOne @JoinColumn(name = "id_sender")
    private Sender sender;

    @NotNull
    private String description;

    @NotNull
    private String fileLocation;
}
