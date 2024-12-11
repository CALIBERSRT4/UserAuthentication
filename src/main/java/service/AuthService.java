package service;


import dto.LoginRequestDto;
import dto.LoginResponseDto;


public interface AuthService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);

}
