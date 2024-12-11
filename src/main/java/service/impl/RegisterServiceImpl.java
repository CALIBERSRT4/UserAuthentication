package service.impl;

import dto.RegisterRequestDto;
import dto.RegisterResponseDto;
import entity.UserEntity;
import entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.crypto.password.PasswordEncoder;
import repository.UserRepository;
import service.RegisterService;

import java.util.List;

public class RegisterServiceImpl implements RegisterService{

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerRequestDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));  // Şifreyi bcrypt ile şifrele
        userEntity.setRoles(List.of(RoleEntity.USER));
        userRepository.save(userEntity);  // Kullanıcıyı veritabanına kaydet

        return new RegisterResponseDto();
    }
}
