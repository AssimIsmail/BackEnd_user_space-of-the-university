package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PaysDTO {

    private Long id;
    private String code;
    private String intituleAr;
    private String intituleFr;
    private String alpha2;
    private String alpha3;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    // Getters and Setters (lombok @Data annotation generates these)
}
