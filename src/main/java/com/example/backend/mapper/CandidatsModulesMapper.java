package com.example.backend.mapper;

import com.example.backend.dto.CandidatsModulesDTO;
import com.example.backend.model.CandidatsModules;
import com.example.backend.model.Candidat;
import com.example.backend.model.Module;
import com.example.backend.model.AnneeUniversitaire;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class CandidatsModulesMapper {

    public static final CandidatsModulesMapper INSTANCE = Mappers.getMapper(CandidatsModulesMapper.class);

    public CandidatsModulesDTO toDTO(CandidatsModules candidatsModules) {
        if (candidatsModules == null) {
            return null;
        }
        CandidatsModulesDTO dto = new CandidatsModulesDTO();
        dto.setId(candidatsModules.getId());
        dto.setIdCandidat(candidatsModules.getCandidat().getId());
        dto.setIdModule(candidatsModules.getModule().getId());
        dto.setMg(candidatsModules.getMg());
        dto.setSession(candidatsModules.getSession());
        dto.setIdAnnee(candidatsModules.getAnneeUniversitaire().getId());
        dto.setCreatedAt(candidatsModules.getCreatedAt());
        dto.setUpdatedAt(candidatsModules.getUpdatedAt());
        dto.setDeletedAt(candidatsModules.getDeletedAt());
        return dto;
    }

    public CandidatsModules fromDTO(CandidatsModulesDTO dto, Candidat candidat, Module module, AnneeUniversitaire anneeUniversitaire) {
        if (dto == null) {
            return null;
        }
        CandidatsModules candidatsModules = new CandidatsModules();
        candidatsModules.setId(dto.getId());
        candidatsModules.setCandidat(candidat);
        candidatsModules.setModule(module);
        candidatsModules.setMg(dto.getMg());
        candidatsModules.setSession(dto.getSession());
        candidatsModules.setAnneeUniversitaire(anneeUniversitaire);
        candidatsModules.setCreatedAt(dto.getCreatedAt());
        candidatsModules.setUpdatedAt(dto.getUpdatedAt());
        candidatsModules.setDeletedAt(dto.getDeletedAt());
        return candidatsModules;
    }
}
