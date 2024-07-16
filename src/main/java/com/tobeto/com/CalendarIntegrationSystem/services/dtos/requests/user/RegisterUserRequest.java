package com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.user;

import com.tobeto.com.CalendarIntegrationSystem.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {

    private String username;

    private String email;

    private String password;

    private Set<Role> roles;
}
