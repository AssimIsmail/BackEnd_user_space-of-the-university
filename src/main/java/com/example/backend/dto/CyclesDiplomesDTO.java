package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CyclesDiplomesDTO {

    private Long id;
    private Long cycleId;
    private Long diplomeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
