package com.example.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CandidatsModulesDTO {

    private Long id;
    private Long idCandidat;
    private Long idModule;
    private Integer mg;
    private String session;
    private Long idAnnee;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
