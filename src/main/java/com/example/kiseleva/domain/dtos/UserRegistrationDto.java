package com.example.kiseleva.domain.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegistrationDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String bio;
}
