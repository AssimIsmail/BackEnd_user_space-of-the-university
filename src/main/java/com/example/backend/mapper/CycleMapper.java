package com.example.backend.mapper;

import com.example.backend.dto.CycleDTO;
import com.example.backend.model.Cycle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class CycleMapper {

    public static final CycleMapper INSTANCE = Mappers.getMapper(CycleMapper.class);

    // Convertir de Cycle à CycleDTO
    public CycleDTO toDTO(Cycle cycle) {
        if (cycle == null) {
            return null;
        }
        CycleDTO dto = new CycleDTO();
        dto.setId(cycle.getId());
        dto.setIntituleFr(cycle.getIntituleFr());
        dto.setIntituleAr(cycle.getIntituleAr());
        dto.setCode(cycle.getCode());
        dto.setNbrFilieres(cycle.getNbrFilieres());
        dto.setAnneeUniv(cycle.getAnneeUniv());
        dto.setDateDebut(cycle.getDateDebut());
        dto.setDateFin(cycle.getDateFin());
        dto.setActive(cycle.getActive());
        dto.setIdAnneeUni(cycle.getIdAnneeUni());
        dto.setPiece(cycle.getPiece());
        dto.setCreatedAt(cycle.getCreatedAt());
        dto.setUpdatedAt(cycle.getUpdatedAt());
        dto.setDeletedAt(cycle.getDeletedAt());
        dto.setTokenCycle(cycle.getTokenCycle());
        dto.setTypeCycle(cycle.getTypeCycle());
        return dto;
    }

    // Convertir de CycleDTO à Cycle
    public Cycle toEntity(CycleDTO dto) {
        if (dto == null) {
            return null;
        }
        Cycle cycle = new Cycle();
        cycle.setId(dto.getId());
        cycle.setIntituleFr(dto.getIntituleFr());
        cycle.setIntituleAr(dto.getIntituleAr());
        cycle.setCode(dto.getCode());
        cycle.setNbrFilieres(dto.getNbrFilieres());
        cycle.setAnneeUniv(dto.getAnneeUniv());
        cycle.setDateDebut(dto.getDateDebut());
        cycle.setDateFin(dto.getDateFin());
        cycle.setActive(dto.getActive());
        cycle.setIdAnneeUni(dto.getIdAnneeUni());
        cycle.setPiece(dto.getPiece());
        cycle.setCreatedAt(dto.getCreatedAt());
        cycle.setUpdatedAt(dto.getUpdatedAt());
        cycle.setDeletedAt(dto.getDeletedAt());
        cycle.setTokenCycle(dto.getTokenCycle());
        cycle.setTypeCycle(dto.getTypeCycle());
        return cycle;
    }
}
