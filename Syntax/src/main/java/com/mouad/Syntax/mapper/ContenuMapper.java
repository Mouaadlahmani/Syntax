package com.mouad.Syntax.mapper;

import com.mouad.Syntax.dto.ContenuDto;
import com.mouad.Syntax.model.Contenu;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ContenuMapper {
        Contenu toEntity(ContenuDto dto);
        List<Contenu> toEntityList(List<ContenuDto> dtoList);
    ContenuDto toDto(Contenu entity);
        List<ContenuDto> toDtoList(List<Contenu> entityList);

}
