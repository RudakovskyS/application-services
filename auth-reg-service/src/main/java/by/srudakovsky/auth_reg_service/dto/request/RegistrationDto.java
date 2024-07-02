package by.srudakovsky.auth_reg_service.dto.request;

import lombok.Data;

@Data
public class RegistrationDto {
    private String username;
    private String password;
}
