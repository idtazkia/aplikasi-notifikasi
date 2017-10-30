package id.ac.tazkia.notification.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity @Table(name = "s_permission")
public class Permission extends BaseEntity {
    @NotNull @NotEmpty @Column(name = "permission_label")
    private String label;
    @NotNull @NotEmpty @Column(name = "permission_value")
    private String value;
}
