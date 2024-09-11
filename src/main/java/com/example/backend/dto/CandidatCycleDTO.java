package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CandidatCycleDTO {

    private Long id;
    private Long candidatId;
    private Long cycleId;
    private Long anneeUniversitaireId;
    private String fichierJoint;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
