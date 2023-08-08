package id.ac.tazkia.notification.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data @Entity
public class Sender extends BaseEntity {
    @NotNull @NotEmpty
    private String name;
    private String smsSenderId;
    private String smsUsername;
    private String smsPassword;
}
