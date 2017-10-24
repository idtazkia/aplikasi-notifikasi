package id.ac.tazkia.notification;

import id.ac.tazkia.notification.dao.NotificationConfigurationDao;
import id.ac.tazkia.notification.dao.NotificationDao;
import id.ac.tazkia.notification.dao.SenderDao;
import id.ac.tazkia.notification.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:sql/delete-sample.sql", "classpath:sql/notification-sample.sql"})
public class NotificationApplicationTests {

    @Autowired private SenderDao senderDao;
    @Autowired private NotificationConfigurationDao notificationConfigurationDao;
    @Autowired private NotificationDao notificationDao;

    @Test
    public void testRun(){
        System.out.println("Aplikasi bisa start tanpa error");
    }

    @Test
    public void testSenderDao(){
        Page<Sender> result = senderDao.findAll(PageRequest.of(0, 3));
        Assert.assertTrue(result.getTotalPages() == 2);
    }

    @Test
    public void testRetrieveNotification(){
        Page<Notification> result = notificationDao.findAll(PageRequest.of(0, 10));
        Assert.assertTrue(result.getTotalElements() > 0);
        Notification notif = result.iterator().next();
        Assert.assertNotNull(notif.getId());
        Assert.assertEquals(NotificationStatus.NEW, notif.getNotificationStatus());
        System.out.println(notif.getSubmitTime());
    }

    @Test
    public void testInsertNotification(){
        Sender s = senderDao.findById("keuangan").get();
        Assert.assertNotNull(s);

        NotificationConfiguration config = notificationConfigurationDao.findById("keu-tagihan").get();
        Assert.assertNotNull(config);

        Notification n = new Notification();
        n.setNotificationConfiguration(config);
        n.setNotificationContent("{\"nama\":\"endy\"}");

        notificationDao.save(n);
        Assert.assertNotNull(n.getId());
    }
}
