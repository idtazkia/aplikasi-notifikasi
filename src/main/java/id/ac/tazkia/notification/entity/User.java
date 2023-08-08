package id.ac.tazkia.notification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity @Table(name = "s_user")
public class User extends BaseEntity {

    @NotNull @NotEmpty
    private String username;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @NotNull
    private Boolean active = Boolean.TRUE;
}
