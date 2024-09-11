package com.example.backend.mapper;

import com.example.backend.dto.DiplomeDTO;
import com.example.backend.model.Diplome;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class DiplomeMapper {

    public static final DiplomeMapper INSTANCE = Mappers.getMapper(DiplomeMapper.class);

    // Convertir de Diplome à DiplomeDTO
    public DiplomeDTO toDTO(Diplome diplome) {
        if (diplome == null) {
            return null;
        }
        DiplomeDTO dto = new DiplomeDTO();
        dto.setId(diplome.getId());
        dto.setCode(diplome.getCode());
        dto.setIntituleAr(diplome.getIntituleAr());
        dto.setIntituleFr(diplome.getIntituleFr());
        dto.setNbrSemestres(diplome.getNbrSemestres());
        dto.setCreatedAt(diplome.getCreatedAt());
        dto.setUpdatedAt(diplome.getUpdatedAt());
        dto.setDeletedAt(diplome.getDeletedAt());
        return dto;
    }

    // Convertir de DiplomeDTO à Diplome
    public Diplome toEntity(DiplomeDTO dto) {
        if (dto == null) {
            return null;
        }
        Diplome diplome = new Diplome();
        diplome.setId(dto.getId());
        diplome.setCode(dto.getCode());
        diplome.setIntituleAr(dto.getIntituleAr());
        diplome.setIntituleFr(dto.getIntituleFr());
        diplome.setNbrSemestres(dto.getNbrSemestres());
        diplome.setCreatedAt(dto.getCreatedAt());
        diplome.setUpdatedAt(dto.getUpdatedAt());
        diplome.setDeletedAt(dto.getDeletedAt());
        return diplome;
    }
}
