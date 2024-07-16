package com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {

    private String username;

    private String password;
}
