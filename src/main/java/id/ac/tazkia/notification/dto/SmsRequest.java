package id.ac.tazkia.notification.dto;

import lombok.Data;

@Data
public class SmsRequest {
    private String destinationNumber;
    private String content;
}
