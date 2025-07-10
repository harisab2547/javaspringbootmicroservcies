package com.example.microservices.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegisterRequest {

    private String FirstName;
    private String lastName;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Email is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;


}
