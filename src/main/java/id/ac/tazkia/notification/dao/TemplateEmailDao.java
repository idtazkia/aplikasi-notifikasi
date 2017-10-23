package id.ac.tazkia.notification.dao;

import id.ac.tazkia.notification.entity.TemplateEmail;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TemplateEmailDao extends PagingAndSortingRepository<TemplateEmail, String>{
}
