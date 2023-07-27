package com.examGenerator.professormanagement.config.security.dto.request;

import com.examGenerator.professormanagement.core.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private String login;
    private String password;
    private UserRole role;
}
