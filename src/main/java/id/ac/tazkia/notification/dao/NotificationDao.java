package id.ac.tazkia.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.tazkia.notification.entity.Notification;

public interface NotificationDao extends JpaRepository<Notification, String>{
}
