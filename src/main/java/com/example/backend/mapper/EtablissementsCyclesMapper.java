package com.example.backend.mapper;

import com.example.backend.dto.EtablissementsCyclesDTO;
import com.example.backend.model.EtablissementsCycles;
import com.example.backend.model.Cycle;
import com.example.backend.model.AnneeUniversitaire;
import com.example.backend.model.EtablissementChoix;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class EtablissementsCyclesMapper {

    public static final EtablissementsCyclesMapper INSTANCE = Mappers.getMapper(EtablissementsCyclesMapper.class);

    public EtablissementsCyclesDTO toDTO(EtablissementsCycles etablissementsCycles) {
        if (etablissementsCycles == null) {
            return null;
        }
        EtablissementsCyclesDTO dto = new EtablissementsCyclesDTO();
        dto.setId(etablissementsCycles.getId());
        dto.setIdEtablissementChoix(etablissementsCycles.getIdEtablissementChoix());
        dto.setIdCycle(etablissementsCycles.getIdCycle());
        dto.setIdAnnee(etablissementsCycles.getIdAnnee());
        dto.setNbrChoix(etablissementsCycles.getNbrChoix());
        dto.setCreatedAt(etablissementsCycles.getCreatedAt());
        dto.setUpdatedAt(etablissementsCycles.getUpdatedAt());
        dto.setDeletedAt(etablissementsCycles.getDeletedAt());
        return dto;
    }

    public EtablissementsCycles fromDTO(EtablissementsCyclesDTO dto, EtablissementChoix etablissementChoix, Cycle cycle, AnneeUniversitaire anneeUniversitaire) {
        if (dto == null) {
            return null;
        }
        EtablissementsCycles etablissementsCycles = new EtablissementsCycles();
        etablissementsCycles.setId(dto.getId());
        etablissementsCycles.setIdEtablissementChoix(dto.getIdEtablissementChoix());
        etablissementsCycles.setIdCycle(dto.getIdCycle());
        etablissementsCycles.setIdAnnee(dto.getIdAnnee());
        etablissementsCycles.setNbrChoix(dto.getNbrChoix());
        etablissementsCycles.setCreatedAt(dto.getCreatedAt());
        etablissementsCycles.setUpdatedAt(dto.getUpdatedAt());
        etablissementsCycles.setDeletedAt(dto.getDeletedAt());
        etablissementsCycles.setEtablissementChoix(etablissementChoix);
        etablissementsCycles.setCycle(cycle);
        etablissementsCycles.setAnneeUniversitaire(anneeUniversitaire);
        return etablissementsCycles;
    }
}
