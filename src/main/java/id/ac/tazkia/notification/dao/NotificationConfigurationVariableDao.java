package id.ac.tazkia.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.tazkia.notification.entity.NotificationConfigurationVariable;

public interface NotificationConfigurationVariableDao extends JpaRepository<NotificationConfigurationVariable, String>{
}
