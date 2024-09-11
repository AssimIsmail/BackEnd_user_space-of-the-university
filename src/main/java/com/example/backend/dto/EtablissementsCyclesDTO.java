package com.example.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EtablissementsCyclesDTO {
    private Long id;
    private Long idEtablissementChoix;
    private Long idCycle;
    private Long idAnnee;
    private Integer nbrChoix;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
