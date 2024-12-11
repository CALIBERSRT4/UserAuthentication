package test;

import dto.LoginRequestDto;
import dto.LoginResponseDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.AuthService;
import lombok.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    public void testLogin() {
        LoginRequestDto request = new LoginRequestDto("egemen", "123");
        LoginResponseDto response = authService.login(request);
        assertNotNull(response);
        assertEquals("egemen", request.getUsername());
    }
}
