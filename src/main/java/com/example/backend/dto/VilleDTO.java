package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VilleDTO {

    private Long id;
    private String code;
    private String intituleFr;
    private String intituleAr;
    private Long paysId; // Assurez-vous que ce champ est mappé correctement
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
