package id.ac.tazkia.notification.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data @Entity
public class TemplateEmail extends BaseEntity {
    @NotNull
    @ManyToOne @JoinColumn(name = "id_sender")
    private Sender sender;

    @NotNull@Column
    private String subject;

    @NotNull@Column
    private String description;

    @NotNull@Column
    private String fileLocation;
}