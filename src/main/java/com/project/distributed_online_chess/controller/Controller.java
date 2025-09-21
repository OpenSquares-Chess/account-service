package com.project.distributed_online_chess.controller;

import com.project.distributed_online_chess.dao.UserRepository;
import com.project.distributed_online_chess.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists.";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully.";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public endpoint.";
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "You are authenticated.";
    }


}
