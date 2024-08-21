package com.mouad.CodeCraft.mapper;

import com.mouad.CodeCraft.dto.LeconDto;
import com.mouad.CodeCraft.model.Lecon;
import org.mapstruct.Mapper;

import java.sql.ResultSet;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LeconMapper {

    Lecon toEntity(LeconDto dto);
    List<Lecon> toEntityList(List<LeconDto> dtoList);
    LeconDto toDto(Lecon entity);
    List<LeconDto> toDtoList(List<Lecon> entityList);

}
