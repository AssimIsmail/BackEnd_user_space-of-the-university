package com.example.backend.mapper;

import com.example.backend.dto.UniversiteDTO;
import com.example.backend.model.Universite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class UniversiteMapper {

    public static final UniversiteMapper INSTANCE = new UniversiteMapper();

    public UniversiteDTO toDTO(Universite universite) {
        if (universite == null) {
            return null;
        }
        UniversiteDTO universiteDTO = new UniversiteDTO();
        universiteDTO.setId(universite.getId());
        universiteDTO.setCode(universite.getCode());
        universiteDTO.setIntituleAr(universite.getIntituleAr());
        universiteDTO.setIntituleFr(universite.getIntituleFr());
        universiteDTO.setActive(universite.getActive());
        universiteDTO.setCreatedAt(universite.getCreatedAt());
        universiteDTO.setUpdatedAt(universite.getUpdatedAt());
        universiteDTO.setDeletedAt(universite.getDeletedAt());
        return universiteDTO;
    }

    public Universite toEntity(UniversiteDTO universiteDTO) {
        if (universiteDTO == null) {
            return null;
        }
        Universite universite = new Universite();
        universite.setId(universiteDTO.getId());
        universite.setCode(universiteDTO.getCode());
        universite.setIntituleAr(universiteDTO.getIntituleAr());
        universite.setIntituleFr(universiteDTO.getIntituleFr());
        universite.setActive(universiteDTO.getActive());
        universite.setCreatedAt(universiteDTO.getCreatedAt());
        universite.setUpdatedAt(universiteDTO.getUpdatedAt());
        universite.setDeletedAt(universiteDTO.getDeletedAt());
        return universite;
    }
}
