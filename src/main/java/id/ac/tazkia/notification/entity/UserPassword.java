package id.ac.tazkia.notification.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @Entity @Table(name = "s_user_password")
public class UserPassword extends BaseEntity {

    @ManyToOne @JoinColumn(name = "id_user")
    private User user;

    @NotNull @NotEmpty
    private String password;
}
