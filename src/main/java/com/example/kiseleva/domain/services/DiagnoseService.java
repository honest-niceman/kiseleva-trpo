package com.example.kiseleva.domain.services;

import com.example.kiseleva.domain.entities.Diagnose;
import com.example.kiseleva.domain.repositories.DiagnoseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnoseService {
    private final DiagnoseRepository diagnoseRepository;

    public DiagnoseService(DiagnoseRepository diagnoseRepository) {
        this.diagnoseRepository = diagnoseRepository;
    }

    public List<Diagnose> findAll() {
        return diagnoseRepository.findAll();
    }

    public Diagnose save(Diagnose entity) {
        return diagnoseRepository.save(entity);
    }

    public Optional<Diagnose> findById(Long id) {
        return diagnoseRepository.findById(id);
    }

    public long count() {
        return diagnoseRepository.count();
    }

    public void deleteById(Long id) {
        diagnoseRepository.deleteById(id);
    }
}
