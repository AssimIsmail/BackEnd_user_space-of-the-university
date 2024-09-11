package com.example.backend.mapper;

import com.example.backend.dto.AnneeUniversitaireDTO;
import com.example.backend.model.AnneeUniversitaire;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class AnneeUniversitaireMapper {

    public static final AnneeUniversitaireMapper INSTANCE = Mappers.getMapper(AnneeUniversitaireMapper.class);

    // Convertir de AnneeUniversitaire à AnneeUniversitaireDTO
    public AnneeUniversitaireDTO toDTO(AnneeUniversitaire anneeUniversitaire) {
        if (anneeUniversitaire == null) {
            return null;
        }
        AnneeUniversitaireDTO dto = new AnneeUniversitaireDTO();
        dto.setId(anneeUniversitaire.getId());
        dto.setIntitule(anneeUniversitaire.getIntitule());
        dto.setEtat(anneeUniversitaire.getEtat());
        dto.setCreatedAt(anneeUniversitaire.getCreatedAt());
        dto.setUpdatedAt(anneeUniversitaire.getUpdatedAt());
        dto.setDeletedAt(anneeUniversitaire.getDeletedAt());
        return dto;
    }

    public AnneeUniversitaire toEntity(AnneeUniversitaireDTO dto) {
        if (dto == null) {
            return null;
        }
        AnneeUniversitaire anneeUniversitaire = new AnneeUniversitaire();
        anneeUniversitaire.setId(dto.getId());
        anneeUniversitaire.setIntitule(dto.getIntitule());  // Assurez-vous que ces valeurs sont bien présentes
        anneeUniversitaire.setEtat(dto.getEtat());
        anneeUniversitaire.setCreatedAt(dto.getCreatedAt());
        anneeUniversitaire.setUpdatedAt(dto.getUpdatedAt());
        anneeUniversitaire.setDeletedAt(dto.getDeletedAt());
        return anneeUniversitaire;
    }

}
