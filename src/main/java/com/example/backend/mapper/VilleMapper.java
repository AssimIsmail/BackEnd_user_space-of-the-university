package com.example.backend.mapper;

import com.example.backend.dto.VilleDTO;
import com.example.backend.model.Ville;
import com.example.backend.model.Pays;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public class VilleMapper {

    @Autowired
    private PaysMapper paysMapper;

    // Convertir de Ville à VilleDTO
    public VilleDTO toDTO(Ville ville) {
        if (ville == null) {
            return null;
        }
        VilleDTO villeDTO = new VilleDTO();
        villeDTO.setId(ville.getId());
        villeDTO.setCode(ville.getCode());
        villeDTO.setIntituleFr(ville.getIntituleFr());
        villeDTO.setIntituleAr(ville.getIntituleAr());
        villeDTO.setPaysId(ville.getPays() != null ? ville.getPays().getId() : null);
        villeDTO.setCreatedAt(ville.getCreatedAt());
        villeDTO.setUpdatedAt(ville.getUpdatedAt());
        villeDTO.setDeletedAt(ville.getDeletedAt());
        return villeDTO;
    }

    // Convertir de VilleDTO à Ville
    public Ville toEntity(VilleDTO villeDTO) {
        if (villeDTO == null) {
            return null;
        }
        Ville ville = new Ville();
        ville.setId(villeDTO.getId());
        ville.setCode(villeDTO.getCode());
        ville.setIntituleFr(villeDTO.getIntituleFr());
        ville.setIntituleAr(villeDTO.getIntituleAr());
        // Assurez-vous de gérer la relation correctement
        // ville.setPays(paysMapper.toEntity(villeDTO.getPaysId())); // Ajoutez cette logique si vous avez un PaysMapper
        ville.setCreatedAt(villeDTO.getCreatedAt());
        ville.setUpdatedAt(villeDTO.getUpdatedAt());
        ville.setDeletedAt(villeDTO.getDeletedAt());
        return ville;
    }
}
