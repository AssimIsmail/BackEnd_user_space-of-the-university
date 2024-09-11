package com.example.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FiliereDTO {

    private Long id;
    private String intituleFr;
    private String intituleAr;
    private Long idCycle; // Utilisé pour la relation avec Cycle
    private String etat;
    private String code;
    private String typeFiliere;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private String tokenFiliere;
    private Long idEtablissementChoix;
}
