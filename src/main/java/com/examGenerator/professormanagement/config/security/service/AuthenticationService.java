package com.examGenerator.professormanagement.config.security.service;

import com.examGenerator.professormanagement.config.security.dto.request.RegisterDTO;
import com.examGenerator.professormanagement.core.model.ApplicationUser;
import com.examGenerator.professormanagement.repository.ApplicationUserRepository;
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
