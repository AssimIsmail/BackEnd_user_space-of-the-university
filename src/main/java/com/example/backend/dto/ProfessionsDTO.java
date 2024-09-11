package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProfessionsDTO {

    private Long id;
    private String code;
    private String intituleAr;
    private String intituleFr;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
