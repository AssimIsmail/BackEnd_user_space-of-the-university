package com.example.backend.mapper;

import com.example.backend.dto.EtablissementDTO;
import com.example.backend.model.Etablissement;
import com.example.backend.model.Universite;
import com.example.backend.repository.UniversiteRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public class EtablissementMapper {
    @Autowired
    private UniversiteRepository universiteRepository;

    public EtablissementDTO toDTO(Etablissement etablissement) {
        if (etablissement == null) {
            return null;
        }
        EtablissementDTO dto = new EtablissementDTO();
        dto.setId(etablissement.getId());
        dto.setCode(etablissement.getCode());
        dto.setIntituleAr(etablissement.getIntituleAr());
        dto.setIntituleFr(etablissement.getIntituleFr());
        dto.setActive(etablissement.isActive());
        dto.setUniversiteId(etablissement.getUniversite() != null ? etablissement.getUniversite().getId() : null);
        dto.setCreatedAt(etablissement.getCreatedAt());
        dto.setUpdatedAt(etablissement.getUpdatedAt());
        dto.setDeletedAt(etablissement.getDeletedAt());
        return dto;
    }

    public Etablissement toEntity(EtablissementDTO dto) {
        if (dto == null) {
            return null;
        }
        Etablissement etablissement = new Etablissement();
        etablissement.setId(dto.getId());
        etablissement.setCode(dto.getCode());
        etablissement.setIntituleAr(dto.getIntituleAr());
        etablissement.setIntituleFr(dto.getIntituleFr());
        etablissement.setActive(dto.isActive());
        Universite universite = universiteRepository.findById(dto.getUniversiteId()).orElse(null);
        etablissement.setUniversite(universite);
        etablissement.setCreatedAt(dto.getCreatedAt());
        etablissement.setUpdatedAt(dto.getUpdatedAt());
        etablissement.setDeletedAt(dto.getDeletedAt());
        return etablissement;
    }
}
