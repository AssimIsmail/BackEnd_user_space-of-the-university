package com.example.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ModuleDTO {
    private Long id;
    private String intituleFr;
    private String intituleAr;
    private Double coefficient;
    private Boolean active;
    private Long idFiliere; // Utilisé pour la relation avec Filiere
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
