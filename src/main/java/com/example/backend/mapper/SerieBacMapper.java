package com.example.backend.mapper;

import com.example.backend.dto.SerieBacDTO;
import com.example.backend.model.SerieBac;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class SerieBacMapper {

    // Instance statique du mapper
    public static final SerieBacMapper INSTANCE = Mappers.getMapper(SerieBacMapper.class);

    // Convertir de SerieBac à SerieBacDTO
    public SerieBacDTO toDTO(SerieBac serieBac) {
        if (serieBac == null) {
            return null;
        }
        SerieBacDTO serieBacDTO = new SerieBacDTO();
        serieBacDTO.setId(serieBac.getId());
        serieBacDTO.setLibelleBaccalaureatFr(serieBac.getLibelleBaccalaureatFr());
        serieBacDTO.setCreatedAt(serieBac.getCreatedAt());
        serieBacDTO.setUpdatedAt(serieBac.getUpdatedAt());
        return serieBacDTO;
    }

    // Convertir de SerieBacDTO à SerieBac
    public SerieBac toEntity(SerieBacDTO serieBacDTO) {
        if (serieBacDTO == null) {
            return null;
        }
        SerieBac serieBac = new SerieBac();
        serieBac.setId(serieBacDTO.getId());
        serieBac.setLibelleBaccalaureatFr(serieBacDTO.getLibelleBaccalaureatFr());
        serieBac.setCreatedAt(serieBacDTO.getCreatedAt());
        serieBac.setUpdatedAt(serieBacDTO.getUpdatedAt());
        return serieBac;
    }
}
