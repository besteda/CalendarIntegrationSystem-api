package com.tobeto.com.CalendarIntegrationSystem.services.concerts;

import com.tobeto.com.CalendarIntegrationSystem.entities.User;
import com.tobeto.com.CalendarIntegrationSystem.repositories.UserRepository;
import com.tobeto.com.CalendarIntegrationSystem.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
