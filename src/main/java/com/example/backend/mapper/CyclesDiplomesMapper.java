package com.example.backend.mapper;

import com.example.backend.dto.CyclesDiplomesDTO;
import com.example.backend.model.Cycle;
import com.example.backend.model.CyclesDiplomes;
import com.example.backend.model.Diplome;
import org.springframework.stereotype.Component;

@Component
public class CyclesDiplomesMapper {

    public static final CyclesDiplomesMapper INSTANCE = new CyclesDiplomesMapper();

    public CyclesDiplomesDTO toDTO(CyclesDiplomes cyclesDiplomes) {
        if (cyclesDiplomes == null) {
            return null;
        }
        CyclesDiplomesDTO dto = new CyclesDiplomesDTO();
        dto.setId(cyclesDiplomes.getId());
        dto.setCycleId(cyclesDiplomes.getCycle().getId());
        dto.setDiplomeId(cyclesDiplomes.getDiplome().getId());
        dto.setCreatedAt(cyclesDiplomes.getCreatedAt());
        dto.setUpdatedAt(cyclesDiplomes.getUpdatedAt());
        dto.setDeletedAt(cyclesDiplomes.getDeletedAt());
        return dto;
    }

    public CyclesDiplomes fromDTO(CyclesDiplomesDTO dto, Cycle cycle, Diplome diplome) {
        if (dto == null) {
            return null;
        }
        CyclesDiplomes cyclesDiplomes = new CyclesDiplomes();
        cyclesDiplomes.setId(dto.getId());
        cyclesDiplomes.setCycle(cycle);
        cyclesDiplomes.setDiplome(diplome);
        cyclesDiplomes.setCreatedAt(dto.getCreatedAt());
        cyclesDiplomes.setUpdatedAt(dto.getUpdatedAt());
        cyclesDiplomes.setDeletedAt(dto.getDeletedAt());
        return cyclesDiplomes;
    }
}
