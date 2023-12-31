package com.example.demo.controlllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("goodbye")
    public ResponseEntity<String> goodbye(){
        return ResponseEntity.ok("goodbye");
    }
}
