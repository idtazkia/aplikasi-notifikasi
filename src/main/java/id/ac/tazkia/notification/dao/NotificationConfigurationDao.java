package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.Notification;
import id.ac.tazkia.notification.entity.NotificationConfiguration;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotificationConfigurationDao extends PagingAndSortingRepository<NotificationConfiguration, String>{
}
