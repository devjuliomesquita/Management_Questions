package com.examGenerator.professorManagement.config.security.controller;

import com.examGenerator.professorManagement.config.security.dto.request.AuthenticationDTO;
import com.examGenerator.professorManagement.config.security.dto.request.RegisterDTO;
import com.examGenerator.professorManagement.config.security.service.AuthenticationService;
import com.examGenerator.professorManagement.core.model.ApplicationUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                authenticationDTO.getLogin(), authenticationDTO.getPassword());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        if (authenticationService.findByLogin(registerDTO) != null) return ResponseEntity.badRequest().build();
        String encyptedPassword = new BCryptPasswordEncoder().encode(registerDTO.getPassword());
        ApplicationUser newUser = ApplicationUser.builder()
                .login(registerDTO.getLogin())
                .password(encyptedPassword)
                .role(registerDTO.getRole())
                .build();
        authenticationService.save(newUser);
        return ResponseEntity.ok().build();
    }
}
