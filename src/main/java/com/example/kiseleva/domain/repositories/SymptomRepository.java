package com.example.kiseleva.domain.repositories;

import com.example.kiseleva.domain.entities.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomRepository extends JpaRepository<Symptom, Long> {}
