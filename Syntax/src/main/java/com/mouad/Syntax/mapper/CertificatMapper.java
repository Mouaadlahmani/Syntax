package com.mouad.Syntax.mapper;

import com.mouad.Syntax.dto.CertificatDto;
import com.mouad.Syntax.model.Certificat;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CertificatMapper {

    Certificat toEntity(CertificatDto dto);
    List<Certificat> toEntityList(List<CertificatDto> dtoList);
    CertificatDto toDto(Certificat entity);
    List<CertificatDto> toDtoList(List<Certificat> entityList);

}
