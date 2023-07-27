package com.examGenerator.professorManagement.repository;

import com.examGenerator.professorManagement.core.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    UserDetails findByLogin(String login);
}
