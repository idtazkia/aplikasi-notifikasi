package id.ac.tazkia.notification;

import id.ac.tazkia.notification.dao.NotificationDao;
import id.ac.tazkia.notification.dao.NotificationVariableDao;
import id.ac.tazkia.notification.dao.SenderDao;
import id.ac.tazkia.notification.entity.Notification;
import id.ac.tazkia.notification.entity.NotificationStatus;
import id.ac.tazkia.notification.entity.NotificationVariable;
import id.ac.tazkia.notification.entity.Sender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:sql/delete-sample.sql", "classpath:sql/notification-sample.sql"})
public class NotificationApplicationTests {

    @Autowired private SenderDao senderDao;
    @Autowired private NotificationDao notificationDao;
    @Autowired private NotificationVariableDao notificationVariableDao;

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

        Iterable<NotificationVariable> vars = notificationVariableDao.findByNotification(notif);
        Assert.assertNotNull(vars);
        
        Integer total = 0;
        for (NotificationVariable var : vars) {
            total++;
        }

        Assert.assertTrue(total == 6);
    }
}
