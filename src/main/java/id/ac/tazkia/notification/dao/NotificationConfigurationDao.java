package id.ac.tazkia.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.tazkia.notification.entity.NotificationConfiguration;

public interface NotificationConfigurationDao extends JpaRepository<NotificationConfiguration, String>{
}
