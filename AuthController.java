package com.example.portfolio_web.controller;

import com.example.portfolio_web.entity.User;
import com.example.portfolio_web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController
{

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {

        // Email check
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists!";
        }

        // Username check
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username already taken!";
        }

        user.setVerified(true);

        userRepository.save(user);

        return "Registered Successfully";
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        return userRepository.findByEmail(user.getEmail())
                .map(u -> {
                    if (u.getPassword().equals(user.getPassword())) {
                        return "Login Successful";
                    } else {
                        return "Wrong Password";
                    }
                })
                .orElse("User Not Found");
    }
    @GetMapping("/count")
    public long getUserCount() {
        return userRepository.count();
    }
}