package com.mouad.syntax.mapper;

import com.mouad.syntax.dto.CertificatDto;
import com.mouad.syntax.model.Certificat;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CertificatMapper {

    Certificat toEntity(CertificatDto dto);
    List<Certificat> toEntityList(List<CertificatDto> dtoList);
    CertificatDto toDto(Certificat entity);
    List<CertificatDto> toDtoList(List<Certificat> entityList);

}
