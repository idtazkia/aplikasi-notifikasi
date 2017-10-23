package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.TemplateSms;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TemplateSmsDao extends PagingAndSortingRepository<TemplateSms, String>{
}
