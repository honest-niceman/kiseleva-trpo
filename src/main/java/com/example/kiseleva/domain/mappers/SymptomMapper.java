package com.example.kiseleva.domain.mappers;

import com.example.kiseleva.domain.dtos.SymptomFullDto;
import com.example.kiseleva.domain.entities.Symptom;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SymptomMapper {
    Symptom toEntity(SymptomFullDto symptomFullDto);

    SymptomFullDto toDto(Symptom symptom);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Symptom partialUpdate(SymptomFullDto symptomFullDto,
                          @MappingTarget Symptom symptom);
}
