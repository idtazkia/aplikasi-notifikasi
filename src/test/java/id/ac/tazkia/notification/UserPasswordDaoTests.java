package id.ac.tazkia.notification;

import id.ac.tazkia.notification.dao.UserPasswordDao;
import id.ac.tazkia.notification.entity.Permission;
import id.ac.tazkia.notification.entity.Role;
import id.ac.tazkia.notification.entity.User;
import id.ac.tazkia.notification.entity.UserPassword;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPasswordDaoTests {
    @Autowired private UserPasswordDao userPasswordDao;

    @Test
    public void testSearchUserByUsername(){
        Optional<UserPassword> up = userPasswordDao.findByUserUsername("client001");
        Assert.assertTrue(up.isPresent());

        int countPermission = up
                .map(UserPassword::getUser)
                .map(User::getRole)
                .map(Role::getPermissions)
                .map(Set::size)
                .orElse(0);

        Assert.assertTrue(1 == countPermission);

        List<String> authorities = up
                .map(UserPassword::getUser)
                .map(User::getRole)
                .map(Role::getPermissions).orElse(new HashSet<Permission>())
                .stream().map(Permission::getValue)
                .collect(Collectors.toList());

        System.out.println("Authorities : "+authorities.toString());
    }
}
