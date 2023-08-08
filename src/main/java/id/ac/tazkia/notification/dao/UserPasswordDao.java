package id.ac.tazkia.notification.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.tazkia.notification.entity.UserPassword;

public interface UserPasswordDao extends JpaRepository<UserPassword, String> {
    Optional<UserPassword> findByUserUsername(String username);
}
