package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@Builder
@Log4j2
public class LoginResponseDto {

    private final String token;
    private String message;

    public LoginResponseDto(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }

}
