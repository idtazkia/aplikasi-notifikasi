package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.SmsNotification;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SmsNotificationDao extends PagingAndSortingRepository<SmsNotification, String> {
}
