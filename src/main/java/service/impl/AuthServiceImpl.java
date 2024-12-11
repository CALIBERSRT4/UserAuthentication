package service.impl;

import dto.LoginRequestDto;
import dto.LoginResponseDto;
import dto.RegisterRequestDto;
import dto.RegisterResponseDto;
import entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.AuthService;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        //kullaniciyi ara
        UserEntity user= userRepository.findByUsername(loginRequestDto.getUsername())
                .orElseGet(() -> {
            //kullanici yoksa yeni olustur
            UserEntity newUser= new UserEntity();
            newUser.setUsername(loginRequestDto.getUsername());
            newUser.setPassword(loginRequestDto.getPassword());
            userRepository.save(newUser);
            return newUser;
        });
        //kullanici var ise sifreyi kontrol et
        if (!user.getPassword().equals(loginRequestDto.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        //login basarili ise
        return new LoginResponseDto("Login successful");
    }


    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        // Burada, kullanıcı kayıt işlemini gerçekleştirebilirsiniz (örneğin, veritabanına kaydetme)

        RegisterResponseDto response = new RegisterResponseDto();
        // Örnek yanıt
        response.setMessage("User registered successfully!");
        response.setUsername(registerRequestDto.getUsername());

        return response;
    }
}
