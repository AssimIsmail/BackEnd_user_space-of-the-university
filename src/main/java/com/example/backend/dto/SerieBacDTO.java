package com.example.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SerieBacDTO {

    private Long id;
    private String libelleBaccalaureatFr;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
}
