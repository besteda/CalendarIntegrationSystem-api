package com.tobeto.com.CalendarIntegrationSystem.controllers;

import com.tobeto.com.CalendarIntegrationSystem.entities.User;
import com.tobeto.com.CalendarIntegrationSystem.services.abstracts.UserService;
import com.tobeto.com.CalendarIntegrationSystem.services.dtos.requests.user.RegisterUserRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UsersController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest){
        if (userService.getByUsername(registerUserRequest.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Kullanıcı adı zaten alınmış.");
        }

        if (userService.getByEmail(registerUserRequest.getEmail()) != null){
            return ResponseEntity.badRequest().body("E-posta adresi daha önce kullanılmış.");
        }

        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        user.setRoles(registerUserRequest.getRoles());

        User registered = userService.register(user);
        return ResponseEntity.ok(registered);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUserRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserRequest.getUsername(),
                        loginUserRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("Giriş başarıyla yapıldı.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<User> user = userService.getById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        User user = userService.getByUsername(username);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        User user = userService.getByEmail(email);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
}
