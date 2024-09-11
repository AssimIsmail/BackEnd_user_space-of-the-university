package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EtablissementChoixDTO {

    private Long id;
    private String intituleAr;
    private String intituleFr;
    private String code;
    private String logo;
    private String adresse;
    private String ville;
    private String email;
    private String tel;
    private String fax;
    private String fix;
    private String mobile;
    private String site;
    private String codePostale;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private String tokenEtablissementChoix;

    // Constructeur sans arguments
    public EtablissementChoixDTO() {
    }

    // Vous pouvez également ajouter d'autres constructeurs si nécessaire
}
