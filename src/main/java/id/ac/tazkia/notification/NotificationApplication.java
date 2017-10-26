package id.ac.tazkia.notification;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotificationApplication {

	@Bean
	public MustacheFactory mustacheFactory(){
		return new DefaultMustacheFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}
}
