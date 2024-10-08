package com.mouad.syntax.mapper;

import com.mouad.syntax.dto.ReponseDto;
import com.mouad.syntax.dto.Reponse;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ReponseMapper {
    Reponse toEntity(ReponseDto dto);
    List<Reponse> toEntityList(List<ReponseDto> dtoList);
    ReponseDto toDto(Reponse entity);
    List<ReponseDto> toDtoList(List<Reponse> entityList);
}
