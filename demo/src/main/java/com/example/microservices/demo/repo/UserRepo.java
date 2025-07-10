package com.example.microservices.demo.repo;

import com.example.microservices.demo.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    boolean existsByEmail(@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email);

}
