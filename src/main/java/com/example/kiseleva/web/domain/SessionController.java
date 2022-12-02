package com.example.kiseleva.web.domain;

import com.example.kiseleva.domain.dtos.SessionFullDto;
import com.example.kiseleva.domain.entities.Session;
import com.example.kiseleva.domain.mappers.SessionMapper;
import com.example.kiseleva.domain.services.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/session")
public class SessionController {
    private final SessionService sessionService;
    private final SessionMapper sessionMapper;

    public SessionController(SessionService sessionService,
                             SessionMapper sessionMapper) {
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    @GetMapping("/find-all")
    public List<SessionFullDto> findAll() {
        return sessionService.findAll()
                             .stream()
                             .map(sessionMapper::toDto)
                             .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public SessionFullDto save(@RequestBody SessionFullDto dto) {
        Session session = sessionMapper.toEntity(dto);
        return sessionMapper.toDto(sessionService.save(session));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        Session session = sessionService.findById(id).orElseThrow();
        return ResponseEntity.ok().body(sessionMapper.toDto(session));
    }

    @GetMapping("/count")
    public long count() {
        return sessionService.count();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam Long id) {
        sessionService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("An entity with id=%d was successfully deleted".formatted(id));
    }
}

