package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ParamsDTO {

    private Long id;
    private String text;
    private String intitule;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
