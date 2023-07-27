package com.examGenerator.professorManagement.config.security.service;

import com.examGenerator.professorManagement.config.security.dto.request.RegisterDTO;
import com.examGenerator.professorManagement.core.model.ApplicationUser;
import com.examGenerator.professorManagement.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    public UserDetails findByLogin(RegisterDTO registerDTO){
        return applicationUserRepository.findByLogin(registerDTO.getLogin());
    }
    public ApplicationUser save(ApplicationUser newUser){
        return applicationUserRepository.save(newUser);
    }
}
