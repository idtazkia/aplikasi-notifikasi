package id.ac.tazkia.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.tazkia.notification.entity.Sender;

public interface SenderDao extends JpaRepository<Sender, String> {
}
