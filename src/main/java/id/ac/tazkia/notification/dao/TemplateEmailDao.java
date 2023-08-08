package id.ac.tazkia.notification.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.tazkia.notification.entity.TemplateEmail;

public interface TemplateEmailDao extends JpaRepository<TemplateEmail, String>{
}
