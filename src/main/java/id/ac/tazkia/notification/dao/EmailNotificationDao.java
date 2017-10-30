package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.EmailNotification;
import id.ac.tazkia.notification.entity.NotificationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmailNotificationDao extends PagingAndSortingRepository<EmailNotification, String> {
    Page<EmailNotification> findByNotificationStatusOrderBySendTime(NotificationStatus status, Pageable page);
}
