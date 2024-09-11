package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AnneeUniversitaireDTO {

    private Long id;
    private String intitule;
    private String etat;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
