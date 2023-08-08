package id.ac.tazkia.notification.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity @Table(name = "s_permission")
public class Permission extends BaseEntity {
    @NotNull @NotEmpty @Column(name = "permission_label")
    private String label;
    @NotNull @NotEmpty @Column(name = "permission_value")
    private String value;
}
