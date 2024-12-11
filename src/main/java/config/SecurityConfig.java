package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder(); // Parola şifrelemesi için BCrypt kullanıyoruz.
        }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login", "/register","/js/login","/js/register","success").permitAll() // Bu sayfalara izin ver
                        .anyRequest().authenticated() // Diğer tüm sayfalar giriş ister
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Özel login sayfamız
                        .defaultSuccessUrl("/success", true) // Login başarılı olursa buraya yönlenir
                        .permitAll()
                );
        return http.build();
    }

    // Basit bir kullanıcı doğrulaması için kullanıcı adı ve şifre ekliyoruz
    @Bean
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin") // Kullanıcı adı
                .password(passwordEncoder().encode("123")) // Şifre
                .roles("USER"); // Rol
    }


}


