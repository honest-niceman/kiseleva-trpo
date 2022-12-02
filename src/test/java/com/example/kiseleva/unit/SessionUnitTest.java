package com.example.kiseleva.unit;

import com.example.kiseleva.domain.entities.Session;
import com.example.kiseleva.domain.entities.User;
import com.example.kiseleva.domain.repositories.SessionRepository;
import com.example.kiseleva.domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SessionUnitTest {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setupData() {
        sessionRepository.deleteAll();
        userRepository.deleteAll();

        User user = new User();
        user.setFirstName("Test");

        Session session = new Session();
        session.setStatus("Open");
        session.setUser(user);

        userRepository.save(user);
        sessionRepository.save(session);
    }

    @Test
    @Order(1)
    public void findTest() {
        sessionRepository.findAll().forEach(System.out::println);

        assertThat(sessionRepository.findAll()).hasSize(1);
    }

    @Test
    @Order(2)
    public void deleteTest() {
        Session session = sessionRepository.findAll()
                                           .get(0);
        sessionRepository.delete(session);
        assertThat(sessionRepository.findAll()).hasSize(0);
    }

    @Test
    @Order(3)
    public void updateTest() {
        Session session = sessionRepository.findAll()
                                           .get(0);
        session.setStatus("Closed");
        sessionRepository.save(session);
        assertThat(sessionRepository.findAll().get(0).getStatus()).isEqualTo("Closed");
    }
}
