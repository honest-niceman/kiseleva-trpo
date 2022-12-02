package com.example.kiseleva.domain.dtos;

import com.example.kiseleva.domain.entities.Role;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.kiseleva.domain.entities.Session} entity
 */
@Data
public class SessionFullDto implements Serializable {
    private final Long id;
    private final DiagnoseDto diagnose;
    private final UserDto user;
    private final String status;

    /**
     * A DTO for the {@link com.example.kiseleva.domain.entities.Diagnose} entity
     */
    @Data
    public static class DiagnoseDto implements Serializable {
        private final Long id;
        private final String name;
    }

    /**
     * A DTO for the {@link com.example.kiseleva.domain.entities.User} entity
     */
    @Data
    public static class UserDto implements Serializable {
        private final Long id;
        private final String firstName;
        private final String lastName;
        private final String username;
        private final Role role;
    }
}
