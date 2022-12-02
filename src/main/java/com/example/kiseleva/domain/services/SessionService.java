package com.example.kiseleva.domain.services;

import com.example.kiseleva.domain.entities.Session;
import com.example.kiseleva.domain.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public Session save(Session entity) {
        return sessionRepository.save(entity);
    }

    public Optional<Session> findById(Long id) {
        return sessionRepository.findById(id);
    }

    public long count() {
        return sessionRepository.count();
    }

    public void deleteById(Long id) {
        sessionRepository.deleteById(id);
    }
}
