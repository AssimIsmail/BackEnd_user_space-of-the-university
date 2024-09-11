package com.example.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CandidatDTO {

    private Long id;
    private String nomFr;
    private String nomAr;
    private String prenomFr;
    private String prenomAr;
    private String cne;
    private String cni;
    private String sexe;
    private LocalDateTime dn; // Date de naissance
    private String lnFr; // Lieu de naissance
    private String lnAr;
    private String tel;
    private String email;
    private String fichierJointOrig;
    private String fichierJointOld;
    private String fichierJoint;
    private String login;
    private String password;
    private String statut;
    private String statutOld;
    private String statutOld2;
    private String statutNew;
    private String motif;
    private String cdDip; // Code Diplôme
    private Long villeId;
    private Long paysId;
    private Long professionId;
    private Long serieBacId;
    private String adresse;
    private String rememberToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private String candidatToken;
    private Integer anneeBac;

//    // Nouveaux attributs ajoutés
//    private String etat;
//    private String justificationUn;
//    private String justificationDeux;
//    private String justificationTrois;
//    private String justificationQuatre;
//    private String justificationCinq;
}
