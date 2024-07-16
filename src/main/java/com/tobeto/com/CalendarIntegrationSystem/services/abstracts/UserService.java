package com.tobeto.com.CalendarIntegrationSystem.services.abstracts;

import com.tobeto.com.CalendarIntegrationSystem.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getById(int id);

    User register(User user);

    User getByUsername(String username);

    User getByEmail(String email);
}
