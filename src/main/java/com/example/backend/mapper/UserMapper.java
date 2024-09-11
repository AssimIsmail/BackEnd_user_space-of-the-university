package com.example.backend.mapper;

import com.example.backend.dto.UserDTO;
import com.example.backend.model.User;
import com.example.backend.model.Etablissement;
import com.example.backend.repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private EtablissementRepository etablissementRepository;

    // Convert User to UserDTO
    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setNom(user.getNom());
        dto.setEmailVerifiedAt(user.getEmailVerifiedAt());
        dto.setPassword(user.getPassword());
        dto.setRememberToken(user.getRememberToken());
        if (user.getEtablissement() != null) {
            dto.setEtablissementId(user.getEtablissement().getId());
        }
        return dto;
    }

    // Convert UserDTO to User
    public User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setNom(dto.getNom());
        user.setEmailVerifiedAt(dto.getEmailVerifiedAt());
        user.setPassword(dto.getPassword());
        user.setRememberToken(dto.getRememberToken());
        if (dto.getEtablissementId() != null) {
            Etablissement etablissement = etablissementRepository.findById(dto.getEtablissementId())
                    .orElseThrow(() -> new IllegalArgumentException("Etablissement with id " + dto.getEtablissementId() + " not found"));
            user.setEtablissement(etablissement);
        } else {
            user.setEtablissement(null);
        }
        return user;
    }
}
