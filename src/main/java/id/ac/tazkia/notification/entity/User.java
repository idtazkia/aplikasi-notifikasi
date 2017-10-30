package id.ac.tazkia.notification.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
