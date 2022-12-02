package com.example.kiseleva.domain.repositories;

import com.example.kiseleva.domain.entities.Diagnose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnoseRepository extends JpaRepository<Diagnose, Long> {}
