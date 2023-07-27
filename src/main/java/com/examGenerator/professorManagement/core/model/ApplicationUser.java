package com.examGenerator.professorManagement.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_user")
public class ApplicationUser extends AbstractEntity{
    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotEmpty
    private String password;
    @OneToOne
    private Professor professor;
}
