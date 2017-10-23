package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.Notification;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotificationDao extends PagingAndSortingRepository<Notification, String>{
}
