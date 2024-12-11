package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class RegisterResponseDto {

    private String username;
    private String message;

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public void setUsername(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
