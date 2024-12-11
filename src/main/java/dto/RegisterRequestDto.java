package dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Data

@Builder
@NoArgsConstructor
@Log4j2
public class RegisterRequestDto {

    private String username;
    private String password;

    public RegisterRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
