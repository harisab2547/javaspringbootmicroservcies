package com.example.microservices.demo.controller;

import com.example.microservices.demo.dto.RegisterRequest;
import com.example.microservices.demo.dto.UserResponse;
import com.example.microservices.demo.service.userService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
@AllArgsConstructor
public class userController {
    @Autowired
    private userService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));

    }

}
