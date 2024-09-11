package com.example.backend.mapper;

import com.example.backend.dto.PaysDTO;
import com.example.backend.model.Pays;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class PaysMapper {

    public PaysDTO toDTO(Pays pays) {
        if (pays == null) {
            return null;
        }
        PaysDTO paysDTO = new PaysDTO();
        paysDTO.setId(pays.getId());
        paysDTO.setCode(pays.getCode());
        paysDTO.setIntituleAr(pays.getIntituleAr());
        paysDTO.setIntituleFr(pays.getIntituleFr());
        paysDTO.setAlpha2(pays.getAlpha2());
        paysDTO.setAlpha3(pays.getAlpha3());
        paysDTO.setCreatedAt(pays.getCreatedAt());
        paysDTO.setUpdatedAt(pays.getUpdatedAt());
        paysDTO.setDeletedAt(pays.getDeletedAt());
        return paysDTO;
    }

    public Pays toEntity(PaysDTO paysDTO) {
        if (paysDTO == null) {
            return null;
        }
        Pays pays = new Pays();
        pays.setId(paysDTO.getId());
        pays.setCode(paysDTO.getCode());
        pays.setIntituleAr(paysDTO.getIntituleAr());
        pays.setIntituleFr(paysDTO.getIntituleFr());
        pays.setAlpha2(paysDTO.getAlpha2());
        pays.setAlpha3(paysDTO.getAlpha3());
        pays.setCreatedAt(paysDTO.getCreatedAt());
        pays.setUpdatedAt(paysDTO.getUpdatedAt());
        pays.setDeletedAt(paysDTO.getDeletedAt());
        return pays;
    }
}
