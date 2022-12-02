package com.example.kiseleva.integration;

import com.example.kiseleva.domain.entities.Session;
import com.example.kiseleva.domain.repositories.SessionRepository;
import com.example.kiseleva.domain.services.SessionService;
import com.example.kiseleva.domain.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityNotFoundException;

@SpringBootTest
public class SessionIntegrationTest {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private UserService userService;

    @Test
    @Sql(scripts = "insert-sessions.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "delete-sessions.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void findAll() {
        System.out.println(sessionRepository.findAll());
        Assertions.assertEquals(3L, sessionService.findAll().size());
    }

    @Test
    @Sql(scripts = "insert-sessions.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "delete-sessions.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void save() {
        Assertions.assertEquals(3L, sessionService.count());
        Session session = new Session();
        session.setUser(userService.findById(1L));
        sessionService.save(session);
        Assertions.assertEquals(4L, sessionService.count());
    }

    @Test
    @Sql(scripts = "insert-sessions.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "delete-sessions.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void findById() {
        Assertions.assertNotNull(sessionService.findById(2L));
    }

    @Test
    @Sql(scripts = "insert-sessions.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "delete-sessions.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void count() {
        Assertions.assertEquals(3L, sessionService.count());
    }

    @Test
    @Sql(scripts = "insert-sessions.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "delete-sessions.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void deleteByIdPositive() {
        Assertions.assertEquals(3L, sessionService.count());
        sessionService.deleteById (2L);
        Assertions.assertEquals(2L, sessionService.count());
    }

    @Test
    void deleteByIdNegative() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> sessionService.deleteById(777L));
    }
}
