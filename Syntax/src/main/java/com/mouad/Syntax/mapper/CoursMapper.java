package com.mouad.Syntax.mapper;

import com.mouad.Syntax.dto.CoursDto;
import com.mouad.Syntax.model.Cours;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CoursMapper {
    Cours toEntity(CoursDto dto);
    List<Cours> toEntityList(List<CoursDto> dtoList);
    CoursDto toDto(Cours entity);
    List<CoursDto> toDtoList(List<Cours> entityList);
}
