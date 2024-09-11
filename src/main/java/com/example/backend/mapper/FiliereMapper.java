package com.example.backend.mapper;

import com.example.backend.dto.FiliereDTO;
import com.example.backend.model.EtablissementChoix;
import com.example.backend.model.Filiere;
import com.example.backend.model.Cycle; // Import nécessaire
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class FiliereMapper {

    public static final FiliereMapper INSTANCE = Mappers.getMapper(FiliereMapper.class);

    private final CycleMapper cycleMapper = CycleMapper.INSTANCE;
    private final EtablissementChoixMapper etablissementChoixMapper = EtablissementChoixMapper.INSTANCE;

    // Convertir de Filiere à FiliereDTO
    public FiliereDTO toDTO(Filiere filiere) {
        if (filiere == null) {
            return null;
        }
        FiliereDTO dto = new FiliereDTO();
        dto.setId(filiere.getId());
        dto.setIntituleFr(filiere.getIntituleFr());
        dto.setIntituleAr(filiere.getIntituleAr());
        dto.setEtat(filiere.getEtat());
        dto.setCode(filiere.getCode());
        dto.setTypeFiliere(filiere.getTypeFiliere());
        dto.setCreatedAt(filiere.getCreatedAt());
        dto.setUpdatedAt(filiere.getUpdatedAt());
        dto.setDeletedAt(filiere.getDeletedAt());
        dto.setTokenFiliere(filiere.getTokenFiliere());

        if (filiere.getCycle() != null) {
            dto.setIdCycle(filiere.getCycle().getId()); // Only set idCycle
        }

        if (filiere.getEtablissementChoix() != null) {
            dto.setIdEtablissementChoix(filiere.getEtablissementChoix().getId());
        }

        return dto;
    }

    // Convertir de FiliereDTO à Filiere
    public Filiere toEntity(FiliereDTO dto) {
        if (dto == null) {
            return null;
        }
        Filiere filiere = new Filiere();
        filiere.setId(dto.getId());
        filiere.setIntituleFr(dto.getIntituleFr());
        filiere.setIntituleAr(dto.getIntituleAr());
        filiere.setEtat(dto.getEtat());
        filiere.setCode(dto.getCode());
        filiere.setTypeFiliere(dto.getTypeFiliere());
        filiere.setCreatedAt(dto.getCreatedAt());
        filiere.setUpdatedAt(dto.getUpdatedAt());
        filiere.setDeletedAt(dto.getDeletedAt());
        filiere.setTokenFiliere(dto.getTokenFiliere());

        if (dto.getIdCycle() != null) {
            Cycle cycle = new Cycle();
            cycle.setId(dto.getIdCycle());
            filiere.setCycle(cycle);
        }

        if (dto.getIdEtablissementChoix() != null) {
            EtablissementChoix etablissementChoix = new EtablissementChoix();
            etablissementChoix.setId(dto.getIdEtablissementChoix());
            filiere.setEtablissementChoix(etablissementChoix);
        }

        return filiere;
    }
}
