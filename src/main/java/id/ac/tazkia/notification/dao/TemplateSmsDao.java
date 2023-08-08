package id.ac.tazkia.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.tazkia.notification.entity.TemplateSms;

public interface TemplateSmsDao extends JpaRepository<TemplateSms, String>{
}
