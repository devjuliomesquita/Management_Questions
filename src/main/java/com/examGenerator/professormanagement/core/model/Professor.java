package com.examGenerator.professormanagement.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_professor")
public class Professor extends AbstractEntity{
    @NotEmpty
    private String name;
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
}
