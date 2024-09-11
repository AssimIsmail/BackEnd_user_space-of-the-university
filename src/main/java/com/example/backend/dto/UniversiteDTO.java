package com.example.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UniversiteDTO {

    private Long id;
    private String code;
    private String intituleAr;
    private String intituleFr;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    // Getters and Setters
}
