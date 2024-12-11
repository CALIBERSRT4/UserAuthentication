package service;


import dto.RegisterRequestDto;
import dto.RegisterResponseDto;

public interface RegisterService {

    RegisterResponseDto register(RegisterRequestDto registerRequestDto);

}
