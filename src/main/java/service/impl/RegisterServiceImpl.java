package service.impl;

import dto.RegisterRequestDto;
import dto.RegisterResponseDto;
import entity.UserEntity;

import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UserRepository;
import service.RegisterService;

public class RegisterServiceImpl implements RegisterService{

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerRequestDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));  // Şifreyi bcrypt ile şifrele

        UserRepository.save(userEntity);  // Kullanıcıyı veritabanına kaydet

        return new RegisterResponseDto();
    }
}
