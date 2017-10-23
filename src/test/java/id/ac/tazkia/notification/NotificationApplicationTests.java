package id.ac.tazkia.notification;

import id.ac.tazkia.notification.dao.SenderDao;
import id.ac.tazkia.notification.entity.Sender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotificationApplicationTests {

    @Autowired private SenderDao senderDao;

    @Test
    public void testRun(){
        System.out.println("Aplikasi bisa start tanpa error");
    }

    @Test
    public void testSenderDao(){
        Page<Sender> result = senderDao.findAll(PageRequest.of(0, 3));
        Assert.assertTrue(result.getTotalPages() == 2);
    }
}
