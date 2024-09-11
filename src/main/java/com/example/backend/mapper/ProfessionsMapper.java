package com.example.backend.mapper;

import com.example.backend.dto.ProfessionsDTO;
import com.example.backend.model.Professions;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class ProfessionsMapper {

    // Instance statique du mapper
    public static final ProfessionsMapper INSTANCE = Mappers.getMapper(ProfessionsMapper.class);

    // Convertir de Professions à ProfessionsDTO
    public ProfessionsDTO toDTO(Professions professions) {
        if (professions == null) {
            return null;
        }
        ProfessionsDTO professionsDTO = new ProfessionsDTO();
        professionsDTO.setId(professions.getId());
        professionsDTO.setCode(professions.getCode());
        professionsDTO.setIntituleAr(professions.getIntituleAr());
        professionsDTO.setIntituleFr(professions.getIntituleFr());
        professionsDTO.setCreatedAt(professions.getCreatedAt());
        professionsDTO.setUpdatedAt(professions.getUpdatedAt());
        professionsDTO.setDeletedAt(professions.getDeletedAt());
        return professionsDTO;
    }

    // Convertir de ProfessionsDTO à Professions
    public Professions toEntity(ProfessionsDTO professionsDTO) {
        if (professionsDTO == null) {
            return null;
        }
        Professions professions = new Professions();
        professions.setId(professionsDTO.getId());
        professions.setCode(professionsDTO.getCode());
        professions.setIntituleAr(professionsDTO.getIntituleAr());
        professions.setIntituleFr(professionsDTO.getIntituleFr());
        professions.setCreatedAt(professionsDTO.getCreatedAt());
        professions.setUpdatedAt(professionsDTO.getUpdatedAt());
        professions.setDeletedAt(professionsDTO.getDeletedAt());
        return professions;
    }
}
