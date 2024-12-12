package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import security.JwtAuthenticationFilter;
import security.JwtTokenUtil;


@Configuration
    @EnableWebSecurity
    public class SecurityConfig {

    private JwtAuthenticationFilter jwtAuthenticationFilter;

    private JwtTokenUtil jwtTokenUtil;

    @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder(); // Parola şifrelemesi için BCrypt kullanıyoruz.
        }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login", "/register").permitAll() // Bu sayfalara izin ver
                        .anyRequest().authenticated() // Diğer tüm sayfalar giriş ister
                )
                .formLogin(AbstractHttpConfigurer::disable); // form login disable edildi
        http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenUtil), UsernamePasswordAuthenticationFilter.class);
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

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}


