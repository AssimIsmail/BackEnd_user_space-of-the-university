package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CritereDTO {

    private Long id;
    private Long idFiliere; 
    private String critere1;
    private String critere2;
    private String critere3;
    private String critere4;
    private String critere5;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
