package com.mouad.syntax.mapper;

import com.mouad.syntax.dto.CoursDto;
import com.mouad.syntax.model.Cours;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CoursMapper {
    Cours toEntity(CoursDto dto);
    List<Cours> toEntityList(List<CoursDto> dtoList);
    CoursDto toDto(Cours entity);
    List<CoursDto> toDtoList(List<Cours> entityList);
}
