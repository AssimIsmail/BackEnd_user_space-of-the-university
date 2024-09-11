package com.example.backend.mapper;

import com.example.backend.dto.ParamsDTO;
import com.example.backend.model.Params;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class ParamsMapper {

    // Instance statique du mapper
    public static final ParamsMapper INSTANCE = Mappers.getMapper(ParamsMapper.class);

    // Convertir de Params à ParamsDTO
    public ParamsDTO toDTO(Params params) {
        if (params == null) {
            return null;
        }
        ParamsDTO paramsDTO = new ParamsDTO();
        paramsDTO.setId(params.getId());
        paramsDTO.setText(params.getText());
        paramsDTO.setIntitule(params.getIntitule());
        paramsDTO.setCreatedAt(params.getCreatedAt());
        paramsDTO.setUpdatedAt(params.getUpdatedAt());
        paramsDTO.setDeletedAt(params.getDeletedAt());
        return paramsDTO;
    }

    // Convertir de ParamsDTO à Params
    public Params toEntity(ParamsDTO paramsDTO) {
        if (paramsDTO == null) {
            return null;
        }
        Params params = new Params();
        params.setId(paramsDTO.getId());
        params.setText(paramsDTO.getText());
        params.setIntitule(paramsDTO.getIntitule());
        params.setCreatedAt(paramsDTO.getCreatedAt());
        params.setUpdatedAt(paramsDTO.getUpdatedAt());
        params.setDeletedAt(paramsDTO.getDeletedAt());
        return params;
    }
}
