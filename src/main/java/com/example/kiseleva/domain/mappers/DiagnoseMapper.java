package com.example.kiseleva.domain.mappers;

import com.example.kiseleva.domain.dtos.DiagnoseFullDto;
import com.example.kiseleva.domain.entities.Diagnose;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DiagnoseMapper {
    Diagnose toEntity(DiagnoseFullDto diagnoseFullDto);

    DiagnoseFullDto toDto(Diagnose diagnose);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Diagnose partialUpdate(DiagnoseFullDto diagnoseFullDto,
                           @MappingTarget Diagnose diagnose);
}
