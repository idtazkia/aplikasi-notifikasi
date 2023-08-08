package id.ac.tazkia.notification.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.tazkia.notification.entity.EmailNotification;
import id.ac.tazkia.notification.entity.NotificationStatus;

public interface EmailNotificationDao extends JpaRepository<EmailNotification, String> {
    Page<EmailNotification> findByNotificationStatusOrderBySendTime(NotificationStatus status, Pageable page);
}
