package com.example.kiseleva.domain.services;

import com.example.kiseleva.domain.entities.Symptom;
import com.example.kiseleva.domain.repositories.SymptomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SymptomService {
    private final SymptomRepository symptomRepository;

    public SymptomService(SymptomRepository symptomRepository) {
        this.symptomRepository = symptomRepository;
    }

    public List<Symptom> findAll() {
        return symptomRepository.findAll();
    }

    public Symptom save(Symptom entity) {
        return symptomRepository.save(entity);
    }

    public Optional<Symptom> findById(Long id) {
        return symptomRepository.findById(id);
    }

    public long count() {
        return symptomRepository.count();
    }

    public void deleteById(Long id) {
        symptomRepository.deleteById(id);
    }
}
