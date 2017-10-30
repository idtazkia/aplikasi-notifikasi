package id.ac.tazkia.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.HttpSecurity;
import org.springframework.security.core.userdetails.MapUserDetailsRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {
    @Bean
    SecurityWebFilterChain springWebFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeExchange()
                .anyExchange().authenticated()
                .and().httpBasic()
                .and().build();
    }

    @Bean
    public MapUserDetailsRepository userDetailsRepository() {
        UserDetails user = User.withUsername("endy")
                .password("test123")
                .authorities("CREATE_NOTIFICATION")
                .build();
        return new MapUserDetailsRepository(user);
    }

}
