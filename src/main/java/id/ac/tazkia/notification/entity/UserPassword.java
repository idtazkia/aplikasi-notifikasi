package id.ac.tazkia.notification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data @Entity @Table(name = "s_user_password")
public class UserPassword extends BaseEntity {

    @ManyToOne @JoinColumn(name = "id_user")
    private User user;

    @NotNull @NotEmpty
    private String password;
}
