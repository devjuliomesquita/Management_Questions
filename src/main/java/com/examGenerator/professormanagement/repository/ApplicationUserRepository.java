package com.examGenerator.professormanagement.repository;

import com.examGenerator.professormanagement.core.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    UserDetails findByLogin(String login);
}
