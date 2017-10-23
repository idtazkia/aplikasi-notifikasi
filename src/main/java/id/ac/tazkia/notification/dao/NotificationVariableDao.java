package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.Notification;
import id.ac.tazkia.notification.entity.NotificationVariable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotificationVariableDao extends PagingAndSortingRepository<NotificationVariable, String>{
    Iterable<NotificationVariable> findByNotification(Notification notification);
}
