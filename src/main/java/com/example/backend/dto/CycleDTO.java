package com.example.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class CycleDTO {
    private Long id;
    private String intituleFr;
    private String intituleAr;
    private String code;
    private Integer nbrFilieres;
    private String anneeUniv;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private Boolean active;
    private Long idAnneeUni;
    private String piece;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private String tokenCycle;
    private String typeCycle;
}
