package com.example.kiseleva.domain.mappers;

import com.example.kiseleva.domain.dtos.SessionFullDto;
import com.example.kiseleva.domain.entities.Session;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {DiagnoseMapper.class})
public interface SessionMapper {
    Session toEntity(SessionFullDto sessionFullDto);

    SessionFullDto toDto(Session session);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Session partialUpdate(SessionFullDto sessionFullDto,
                          @MappingTarget Session session);
}
