package com.example.kiseleva.web.domain;

import com.example.kiseleva.domain.dtos.SymptomFullDto;
import com.example.kiseleva.domain.entities.Symptom;
import com.example.kiseleva.domain.mappers.SymptomMapper;
import com.example.kiseleva.domain.services.SymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/symptom")
public class SymptomController {
    private final SymptomService symptomService;
    private final SymptomMapper symptomMapper;

    public SymptomController(SymptomService symptomService,
                             SymptomMapper symptomMapper) {
        this.symptomService = symptomService;
        this.symptomMapper = symptomMapper;
    }

    @GetMapping("/find-all")
    public List<SymptomFullDto> findAll() {
        return symptomService.findAll()
                             .stream()
                             .map(symptomMapper::toDto)
                             .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public SymptomFullDto save(@RequestBody SymptomFullDto dto) {
        Symptom symptom = symptomMapper.toEntity(dto);
        return symptomMapper.toDto(symptomService.save(symptom));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        Symptom symptom = symptomService.findById(id).orElseThrow();
        return ResponseEntity.ok().body(symptomMapper.toDto(symptom));
    }

    @GetMapping("/count")
    public long count() {
        return symptomService.count();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam Long id) {
        symptomService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("An entity with id=%d was successfully deleted".formatted(id));
    }
}

