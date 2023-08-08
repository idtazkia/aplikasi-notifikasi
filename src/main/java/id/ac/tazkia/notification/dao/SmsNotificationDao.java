package id.ac.tazkia.notification.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.tazkia.notification.entity.NotificationStatus;
import id.ac.tazkia.notification.entity.SmsNotification;

public interface SmsNotificationDao extends JpaRepository<SmsNotification, String> {
    Page<SmsNotification> findByNotificationStatusOrderBySendTime(NotificationStatus status, Pageable page);
}
