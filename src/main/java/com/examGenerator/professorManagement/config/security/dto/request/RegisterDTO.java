package com.examGenerator.professorManagement.config.security.dto.request;

import com.examGenerator.professorManagement.core.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private String login;
    private String password;
    private UserRole role;
}
