package id.ac.tazkia.notification.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @Entity
public class Sender extends BaseEntity {

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @Column(name = "sms_sender_id",nullable = false)
    private String smsSenderId;

    @Column(name = "sms_username",nullable = false)
    private String smsUsername;

    @Column(name = "sms_password",nullable = false)
    private String smsPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmsSenderId() {
        return smsSenderId;
    }

    public void setSmsSenderId(String smsSenderId) {
        this.smsSenderId = smsSenderId;
    }

    public String getSmsUsername() {
        return smsUsername;
    }

    public void setSmsUsername(String smsUsername) {
        this.smsUsername = smsUsername;
    }

    public String getSmsPassword() {
        return smsPassword;
    }

    public void setSmsPassword(String smsPassword) {
        this.smsPassword = smsPassword;
    }


}

