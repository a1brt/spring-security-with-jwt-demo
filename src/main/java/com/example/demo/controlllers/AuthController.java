package com.example.demo.controlllers;

import com.example.demo.domain.RegistrationDto;
import com.example.demo.domain.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDto request) {
        return authService.register(request.getUsername(), request.getPassword());
    }
}
