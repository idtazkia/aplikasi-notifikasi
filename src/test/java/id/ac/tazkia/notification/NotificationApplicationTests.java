package id.ac.tazkia.notification;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.tazkia.notification.dao.NotificationConfigurationDao;
import id.ac.tazkia.notification.dao.NotificationDao;
import id.ac.tazkia.notification.dao.SenderDao;
import id.ac.tazkia.notification.dto.NotificationRequest;
import id.ac.tazkia.notification.entity.Notification;
import id.ac.tazkia.notification.entity.NotificationConfiguration;
import id.ac.tazkia.notification.entity.Sender;
import id.ac.tazkia.notification.service.NotificationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:sql/delete-sample.sql", "classpath:sql/notification-sample.sql"})
public class NotificationApplicationTests {

    @Autowired private SenderDao senderDao;
    @Autowired private NotificationConfigurationDao notificationConfigurationDao;
    @Autowired private NotificationDao notificationDao;
    @Autowired private NotificationService notificationService;
    @Autowired private ObjectMapper objectMapper;

    @Value("classpath:/json/notification-data.json")
    private Resource notificationData;
    @Value("classpath:/json/create-notification.json")
    private Resource notificationRequest;

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
        System.out.println(notif.getSubmitTime());
    }

    @Test
    public void testInsertNotification() throws IOException {
        Sender s = senderDao.findById("keuangan").get();
        Assert.assertNotNull(s);

        NotificationConfiguration config = notificationConfigurationDao.findById("keu-tagihan").get();
        Assert.assertNotNull(config);

        Notification n = new Notification();
        n.setNotificationConfiguration(config);
        n.setNotificationData(new String(FileCopyUtils.copyToByteArray(notificationData.getFile())));

        notificationDao.save(n);
        Assert.assertNotNull(n.getId());
    }

    @Test
    public void testCreateNotification() throws IOException {
        NotificationRequest request = objectMapper.readValue(notificationRequest.getFile(), NotificationRequest.class);
        NotificationConfiguration config = notificationConfigurationDao.findById("keu-tagihan").get();
        notificationService.create(config, request);
    }
}
