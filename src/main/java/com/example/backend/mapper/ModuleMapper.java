package com.example.backend.mapper;

import com.example.backend.dto.ModuleDTO;
import com.example.backend.model.Module;
import com.example.backend.model.Filiere; // Import necessary for relation with Filiere
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class ModuleMapper {

    public static final ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);

    // Convert from Module to ModuleDTO
    public ModuleDTO toDTO(Module module) {
        if (module == null) {
            return null;
        }
        ModuleDTO dto = new ModuleDTO();
        dto.setId(module.getId());
        dto.setIntituleFr(module.getIntituleFr());
        dto.setIntituleAr(module.getIntituleAr());
        dto.setCoefficient(module.getCoefficient());
        dto.setActive(module.getActive());
        dto.setCreatedAt(module.getCreatedAt());
        dto.setUpdatedAt(module.getUpdatedAt());
        dto.setDeletedAt(module.getDeletedAt());

        if (module.getFiliere() != null) {
            dto.setIdFiliere(module.getFiliere().getId());
        }

        return dto;
    }

    // Convert from ModuleDTO to Module
    public Module toEntity(ModuleDTO dto) {
        if (dto == null) {
            return null;
        }
        Module module = new Module();
        module.setId(dto.getId());
        module.setIntituleFr(dto.getIntituleFr());
        module.setIntituleAr(dto.getIntituleAr());
        module.setCoefficient(dto.getCoefficient());
        module.setActive(dto.getActive());
        module.setCreatedAt(dto.getCreatedAt());
        module.setUpdatedAt(dto.getUpdatedAt());
        module.setDeletedAt(dto.getDeletedAt());

        if (dto.getIdFiliere() != null) {
            Filiere filiere = new Filiere();
            filiere.setId(dto.getIdFiliere());
            module.setFiliere(filiere);
        }

        return module;
    }
}
