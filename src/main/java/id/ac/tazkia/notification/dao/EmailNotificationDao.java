package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.EmailNotification;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmailNotificationDao extends PagingAndSortingRepository<EmailNotification, String> {
}
