package id.ac.tazkia.notification.dto;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationRequest {
    private String konfigurasi;
    private String email;
    private String mobile;
    @NotNull @NotEmpty
    private Map<String, String> data = new HashMap<>();
}
