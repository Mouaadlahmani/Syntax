package com.mouad.syntax.mapper;

import com.mouad.syntax.dto.LeconDto;
import com.mouad.syntax.model.Lecon;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LeconMapper {

    Lecon toEntity(LeconDto dto);
    List<Lecon> toEntityList(List<LeconDto> dtoList);
    LeconDto toDto(Lecon entity);
    List<LeconDto> toDtoList(List<Lecon> entityList);

}
