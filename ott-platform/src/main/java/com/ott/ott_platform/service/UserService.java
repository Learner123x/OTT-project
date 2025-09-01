package com.ott.platform.service;

import com.ott.platform.model.User;
import com.ott.platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service component
public class UserService {

    @Autowired // Injects an instance of UserRepository
    private UserRepository userRepository;

    public User registerUser(User newUser) {
        // Check if username or email already exists to prevent duplicates
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        
        // *** SECURITY WARNING: In a real app, hash the password before saving! ***
        // Example using a placeholder hashing function:
        // newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        
        return userRepository.save(newUser);
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        
        // *** SECURITY WARNING: This is a plain text password check for demonstration only! ***
        // In a real app, you would use a method like passwordEncoder.matches(password, user.getPassword())
        if (user != null && user.getPassword().equals(password)) {
            return user; // Successful login
        }
        
        return null; // Failed login
    }
}