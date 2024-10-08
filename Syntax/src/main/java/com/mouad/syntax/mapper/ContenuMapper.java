package com.mouad.syntax.mapper;

import com.mouad.syntax.dto.ContenuDto;
import com.mouad.syntax.model.Contenu;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ContenuMapper {
        Contenu toEntity(ContenuDto dto);
        List<Contenu> toEntityList(List<ContenuDto> dtoList);
    ContenuDto toDto(Contenu entity);
        List<ContenuDto> toDtoList(List<Contenu> entityList);

}
