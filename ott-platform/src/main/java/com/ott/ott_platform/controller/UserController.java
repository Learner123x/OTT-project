package com.ott.platform.controller;

import com.ott.platform.dto.LoginRequest;
import com.ott.platform.model.User;
import com.ott.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // This annotation combines @Controller and @ResponseBody
@RequestMapping("/api/users") // Base URL for all endpoints in this controller
public class UserController {

    @Autowired // Injects an instance of UserService
    private UserService userService;

    @PostMapping("/register") // Maps HTTP POST requests to /api/users/register
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Return a more informative error response
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login") // Maps HTTP POST requests to /api/users/login
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (user != null) {
            // On successful login, you might return the user object or a token (like a JWT)
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }
}