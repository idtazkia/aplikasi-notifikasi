package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.UserPassword;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserPasswordDao extends PagingAndSortingRepository<UserPassword, String> {
    Optional<UserPassword> findByUserUsername(String username);
}
