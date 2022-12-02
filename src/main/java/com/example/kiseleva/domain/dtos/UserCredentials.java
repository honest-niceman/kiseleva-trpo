package com.example.kiseleva.domain.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserCredentials implements Serializable {
    private final String password;
    private final String username;
}
