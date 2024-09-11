package com.example.backend.mapper;

import com.example.backend.dto.CandidatCycleDTO;
import com.example.backend.model.CandidatsCycles;
import com.example.backend.model.Candidat;
import com.example.backend.model.Cycle;
import com.example.backend.model.AnneeUniversitaire;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class CandidatsCyclesMapper {

    public static final CandidatsCyclesMapper INSTANCE = Mappers.getMapper(CandidatsCyclesMapper.class);

    public CandidatCycleDTO toDTO(CandidatsCycles candidatsCycles) {
        if (candidatsCycles == null) {
            return null;
        }
        CandidatCycleDTO dto = new CandidatCycleDTO();
        dto.setId(candidatsCycles.getId());
        dto.setCandidatId(candidatsCycles.getCandidat().getId());
        dto.setCycleId(candidatsCycles.getCycle().getId());
        dto.setAnneeUniversitaireId(candidatsCycles.getAnneeUniversitaire().getId());
        dto.setFichierJoint(candidatsCycles.getFichierJoint());
        dto.setCreatedAt(candidatsCycles.getCreatedAt());
        dto.setUpdatedAt(candidatsCycles.getUpdatedAt());
        dto.setDeletedAt(candidatsCycles.getDeletedAt());
        return dto;
    }

    public CandidatsCycles fromDTO(CandidatCycleDTO dto, Candidat candidat, Cycle cycle, AnneeUniversitaire anneeUniversitaire) {
        if (dto == null) {
            return null;
        }
        CandidatsCycles candidatsCycles = new CandidatsCycles();
        candidatsCycles.setId(dto.getId());
        candidatsCycles.setCandidat(candidat);
        candidatsCycles.setCycle(cycle);
        candidatsCycles.setAnneeUniversitaire(anneeUniversitaire);
        candidatsCycles.setFichierJoint(dto.getFichierJoint());
        candidatsCycles.setCreatedAt(dto.getCreatedAt());
        candidatsCycles.setUpdatedAt(dto.getUpdatedAt());
        candidatsCycles.setDeletedAt(dto.getDeletedAt());
        return candidatsCycles;
    }
}
