package com.example.kiseleva.web.domain;

import com.example.kiseleva.domain.dtos.DiagnoseFullDto;
import com.example.kiseleva.domain.entities.Diagnose;
import com.example.kiseleva.domain.mappers.DiagnoseMapper;
import com.example.kiseleva.domain.services.DiagnoseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/diagnose")
public class DiagnoseController {
    private final DiagnoseService diagnoseService;
    private final DiagnoseMapper diagnoseMapper;

    public DiagnoseController(DiagnoseService diagnoseService,
                              DiagnoseMapper diagnoseMapper) {
        this.diagnoseService = diagnoseService;
        this.diagnoseMapper = diagnoseMapper;
    }

    @GetMapping("/find-all")
    public List<DiagnoseFullDto> findAll() {
        return diagnoseService.findAll()
                              .stream()
                              .map(diagnoseMapper::toDto)
                              .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public DiagnoseFullDto save(@RequestBody DiagnoseFullDto dto) {
        Diagnose diagnose = diagnoseMapper.toEntity(dto);
        return diagnoseMapper.toDto(diagnoseService.save(diagnose));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        Diagnose diagnose = diagnoseService.findById(id).orElseThrow();
        return ResponseEntity.ok().body(diagnoseMapper.toDto(diagnose));
    }

    @GetMapping("/count")
    public long count() {
        return diagnoseService.count();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam Long id) {
        diagnoseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("An entity with id=%d was successfully deleted".formatted(id));
    }
}
