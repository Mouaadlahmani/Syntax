package com.mouad.Syntax.mapper;

import com.mouad.Syntax.dto.LeconDto;
import com.mouad.Syntax.model.Lecon;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LeconMapper {

    Lecon toEntity(LeconDto dto);
    List<Lecon> toEntityList(List<LeconDto> dtoList);
    LeconDto toDto(Lecon entity);
    List<LeconDto> toDtoList(List<Lecon> entityList);

}
