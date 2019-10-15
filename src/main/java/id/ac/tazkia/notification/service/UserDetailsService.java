package id.ac.tazkia.notification.service;

import id.ac.tazkia.notification.dao.UserPasswordDao;
import id.ac.tazkia.notification.dto.MyUserDetails;
import id.ac.tazkia.notification.entity.Permission;
import id.ac.tazkia.notification.entity.Role;
import id.ac.tazkia.notification.entity.User;
import id.ac.tazkia.notification.entity.UserPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsService implements ReactiveUserDetailsService {

    @Autowired private UserPasswordDao userPasswordDao;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        Optional<UserPassword> queryResult = userPasswordDao.findByUserUsername(username);

        List<String> authorities = queryResult
                .map(UserPassword::getUser)
                .map(User::getRole)
                .map(Role::getPermissions).orElse(new HashSet<Permission>())
                .stream().map(Permission::getValue)
                .collect(Collectors.toList());

        return queryResult.map(up -> {
            return Mono.just((UserDetails) MyUserDetails.builder()
                    .active(up.getUser().getActive())
                    .authorities(authorities)
                    .password(up.getPassword())
                    .username(username)
                    .build());
        }).orElse(Mono.empty());
    }
}
