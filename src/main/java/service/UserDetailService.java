package service;

import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles("USER")  // Burada kullanıcı rollerini belirleyebilirsiniz
                .build();
    }

    /**
     * Configures and returns a {@link UserDetailsService} with predefined in-memory users.
     * This method defines two users: "user" with the role "USER" and "admin" with the role "ADMIN".
     * Passwords are encoded using the provided {@code PasswordEncoder}.
     *
     * @param passwordEncoder the {@link PasswordEncoder} used to encode the user passwords
     * @return an instance of {@link InMemoryUserDetailsManager} containing the defined users
     */
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password")) // Şifre encode ediliyor
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("adminpass")) // Şifre encode ediliyor
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
