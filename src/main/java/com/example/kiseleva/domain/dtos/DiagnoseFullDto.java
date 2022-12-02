package com.example.kiseleva.domain.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.kiseleva.domain.entities.Diagnose} entity
 */
@Data
public class DiagnoseFullDto implements Serializable {
    private final Long id;
    private final String name;
}
