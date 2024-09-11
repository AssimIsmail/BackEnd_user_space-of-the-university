package com.example.backend.mapper;

import com.example.backend.dto.CritereDTO;
import com.example.backend.model.Critere;
import com.example.backend.model.Filiere; // Import nécessaire
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class CritereMapper {

    public static final CritereMapper INSTANCE = Mappers.getMapper(CritereMapper.class);

    // Convertir de Critere à CritereDTO
    public CritereDTO toDTO(Critere critere) {
        if (critere == null) {
            return null;
        }
        CritereDTO dto = new CritereDTO();
        dto.setId(critere.getId());
        dto.setCritere1(critere.getCritere1());
        dto.setCritere2(critere.getCritere2());
        dto.setCritere3(critere.getCritere3());
        dto.setCritere4(critere.getCritere4());
        dto.setCritere5(critere.getCritere5());
        dto.setCreatedAt(critere.getCreatedAt());
        dto.setUpdatedAt(critere.getUpdatedAt());
        dto.setDeletedAt(critere.getDeletedAt());

        if (critere.getFiliere() != null) {
            dto.setIdFiliere(critere.getFiliere().getId()); // Only set idFiliere
        }

        return dto;
    }

    // Convertir de CritereDTO à Critere
    public Critere toEntity(CritereDTO dto) {
        if (dto == null) {
            return null;
        }
        Critere critere = new Critere();
        critere.setId(dto.getId());
        critere.setCritere1(dto.getCritere1());
        critere.setCritere2(dto.getCritere2());
        critere.setCritere3(dto.getCritere3());
        critere.setCritere4(dto.getCritere4());
        critere.setCritere5(dto.getCritere5());
        critere.setCreatedAt(dto.getCreatedAt());
        critere.setUpdatedAt(dto.getUpdatedAt());
        critere.setDeletedAt(dto.getDeletedAt());

        if (dto.getIdFiliere() != null) {
            Filiere filiere = new Filiere();
            filiere.setId(dto.getIdFiliere());
            critere.setFiliere(filiere);
        }

        return critere;
    }
}
