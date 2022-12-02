package com.example.kiseleva.domain.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.kiseleva.domain.entities.Symptom} entity
 */
@Data
public class SymptomFullDto implements Serializable {
    private final Long id;
    private final String name;
}
