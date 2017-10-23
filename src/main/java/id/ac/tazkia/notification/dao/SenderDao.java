package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.Sender;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SenderDao extends PagingAndSortingRepository<Sender, String> {
}
