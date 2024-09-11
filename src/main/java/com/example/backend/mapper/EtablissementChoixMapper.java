package com.example.backend.mapper;

import com.example.backend.dto.EtablissementChoixDTO;
import com.example.backend.model.EtablissementChoix;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class EtablissementChoixMapper {

    public static final EtablissementChoixMapper INSTANCE = Mappers.getMapper(EtablissementChoixMapper.class);

    // Convertir de EtablissementChoix à EtablissementChoixDTO
    public EtablissementChoixDTO toDTO(EtablissementChoix etablissementChoix) {
        if (etablissementChoix == null) {
            return null;
        }
        EtablissementChoixDTO dto = new EtablissementChoixDTO();
        dto.setId(etablissementChoix.getId());
        dto.setIntituleAr(etablissementChoix.getIntituleAr());
        dto.setIntituleFr(etablissementChoix.getIntituleFr());
        dto.setCode(etablissementChoix.getCode());
        dto.setLogo(etablissementChoix.getLogo());
        dto.setAdresse(etablissementChoix.getAdresse());
        dto.setVille(etablissementChoix.getVille());
        dto.setEmail(etablissementChoix.getEmail());
        dto.setTel(etablissementChoix.getTel());
        dto.setFax(etablissementChoix.getFax());
        dto.setFix(etablissementChoix.getFix());
        dto.setMobile(etablissementChoix.getMobile());
        dto.setSite(etablissementChoix.getSite());
        dto.setCodePostale(etablissementChoix.getCodePostale());
        dto.setCreatedAt(etablissementChoix.getCreatedAt());
        dto.setUpdatedAt(etablissementChoix.getUpdatedAt());
        dto.setDeletedAt(etablissementChoix.getDeletedAt());
        dto.setTokenEtablissementChoix(etablissementChoix.getTokenEtablissementChoix());
        return dto;
    }

    // Convertir de EtablissementChoixDTO à EtablissementChoix
    public EtablissementChoix toEntity(EtablissementChoixDTO dto) {
        if (dto == null) {
            return null;
        }
        EtablissementChoix etablissementChoix = new EtablissementChoix();
        etablissementChoix.setId(dto.getId());
        etablissementChoix.setIntituleAr(dto.getIntituleAr());
        etablissementChoix.setIntituleFr(dto.getIntituleFr());
        etablissementChoix.setCode(dto.getCode());
        etablissementChoix.setLogo(dto.getLogo());
        etablissementChoix.setAdresse(dto.getAdresse());
        etablissementChoix.setVille(dto.getVille());
        etablissementChoix.setEmail(dto.getEmail());
        etablissementChoix.setTel(dto.getTel());
        etablissementChoix.setFax(dto.getFax());
        etablissementChoix.setFix(dto.getFix());
        etablissementChoix.setMobile(dto.getMobile());
        etablissementChoix.setSite(dto.getSite());
        etablissementChoix.setCodePostale(dto.getCodePostale());
        etablissementChoix.setCreatedAt(dto.getCreatedAt());
        etablissementChoix.setUpdatedAt(dto.getUpdatedAt());
        etablissementChoix.setDeletedAt(dto.getDeletedAt());
        etablissementChoix.setTokenEtablissementChoix(dto.getTokenEtablissementChoix());
        return etablissementChoix;
    }
}
