package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.NotificationConfigurationVariable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotificationConfigurationVariableDao extends PagingAndSortingRepository<NotificationConfigurationVariable, String>{
}
