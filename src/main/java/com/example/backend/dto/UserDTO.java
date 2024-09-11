package com.example.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String nom;
    private LocalDateTime emailVerifiedAt;
    private String password;
    private Long etablissementId; // This field can be null
    private String rememberToken;
}
