package controller;


import dto.RegisterRequestDto;
import dto.RegisterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.RegisterService;

import java.util.List;

@RestController
@RequestMapping("/api/register")
public class RegisterController{

    @Autowired
    private RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
        RegisterResponseDto response = registerService.register(registerRequestDto);

        return ResponseEntity.ok(response);
    }



}
