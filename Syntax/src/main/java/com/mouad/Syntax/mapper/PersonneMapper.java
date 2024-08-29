package com.mouad.Syntax.mapper;

import com.mouad.Syntax.dto.PersonneDto;
import com.mouad.Syntax.model.Personne;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PersonneMapper {
    Personne toEntity(PersonneDto dto);
    List<Personne> toEntityList(List<PersonneDto> dtoList);
    PersonneDto toDto(Personne entity);
    List<PersonneDto> toDtoList(List<Personne> entityList);
}
