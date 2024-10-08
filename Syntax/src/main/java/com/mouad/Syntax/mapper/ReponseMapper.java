package com.mouad.Syntax.mapper;

import com.mouad.Syntax.dto.ReponseDto;
import com.mouad.Syntax.dto.Reponse;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ReponseMapper {
    Reponse toEntity(ReponseDto dto);
    List<Reponse> toEntityList(List<ReponseDto> dtoList);
    ReponseDto toDto(Reponse entity);
    List<ReponseDto> toDtoList(List<Reponse> entityList);
}
