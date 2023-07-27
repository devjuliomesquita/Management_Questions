package com.examGenerator.professormanagement.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationUser extends AbstractEntity implements UserDetails {
    @NotEmpty
    @Column(unique = true)
    private String login;
    @NotEmpty
    private String password;
    @OneToOne
    private Professor professor;
    @NotNull
    private UserRole role;

    public ApplicationUser(String login, String password, UserRole role){
        this.login = login;
        this.password = password;
        this.role = role;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROlE_ADMIN"), new SimpleGrantedAuthority("ROlE_USER"));
        }else {
            return List.of(new SimpleGrantedAuthority("ROlE_USER"));
        }
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
