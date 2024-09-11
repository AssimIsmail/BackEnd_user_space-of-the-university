package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EtablissementDTO {
    private Long id;
    private String code;
    private String intituleFr;
    private String intituleAr;
    private boolean active; // Assurez-vous que ce champ existe
    private Long universiteId; // ID de l'université
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
