package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.NotificationStatus;
import id.ac.tazkia.notification.entity.SmsNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SmsNotificationDao extends PagingAndSortingRepository<SmsNotification, String> {
    Page<SmsNotification> findByNotificationStatusOrderBySendTime(NotificationStatus status, Pageable page);
}
