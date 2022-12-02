package com.example.kiseleva.domain.repositories;

import com.example.kiseleva.domain.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {}
