package id.ac.tazkia.notification.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Data
public class NotificationRequest {
    private String konfigurasi;
    private String email;
    private String mobile;
    @NotNull @NotEmpty
    private Map<String, String> data = new HashMap<>();
}
