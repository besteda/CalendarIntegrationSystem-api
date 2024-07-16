package com.tobeto.com.CalendarIntegrationSystem.repositories;

import com.tobeto.com.CalendarIntegrationSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    User findByEmail(String email);
}
