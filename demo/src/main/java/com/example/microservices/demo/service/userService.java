package com.example.microservices.demo.service;

import com.example.microservices.demo.dto.RegisterRequest;
import com.example.microservices.demo.dto.UserResponse;
import com.example.microservices.demo.model.User;
import com.example.microservices.demo.repo.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private UserRepo repo;

    public UserResponse register(@Valid RegisterRequest request) {

        if (repo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        User savedUser = repo.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreateAt(savedUser.getCreateAt());
        userResponse.setUpdateAt(savedUser.getUpdateAt());
        return userResponse;

    }

    public UserResponse getUserProfile(String userId) {

        User user = repo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreateAt(user.getCreateAt());
        userResponse.setUpdateAt(user.getUpdateAt());
        return userResponse;

    }
}
