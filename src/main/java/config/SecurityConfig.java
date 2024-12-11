package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // CSRF korumasını devre dışı bırakıyoruz (API için genelde böyle yapılır)
                .authorizeRequests()
                .antMatchers("/login", "/register").permitAll()  // Login ve register endpoint'lerine herkesin erişmesine izin ver
                .anyRequest().authenticated()  // Diğer tüm endpoint'ler için kimlik doğrulaması gerekiyor
                .and()
                .formLogin().disable()  // Default login formunu devre dışı bırakıyoruz (API kullanıyorsanız genelde bu yapılır)
                .httpBasic();  // Basic Authentication kullanıyoruz

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Şifreleri güvenli bir şekilde şifrele
    }
}