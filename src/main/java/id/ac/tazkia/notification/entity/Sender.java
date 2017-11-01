package id.ac.tazkia.notification.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @Entity
public class Sender extends BaseEntity {
    @NotNull @NotEmpty
    private String name;
    private String smsSenderId;
    private String smsUsername;
    private String smsPassword;
}
