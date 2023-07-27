package com.examGenerator.professormanagement.config.security.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDTO {
    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
}
