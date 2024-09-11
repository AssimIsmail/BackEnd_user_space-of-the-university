package com.example.backend.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "candidats")
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String adresse;
    private String rememberToken;

    @ManyToOne
    @JoinColumn(name = "ville_id", nullable = false)
    private Ville ville;

    @ManyToOne
    @JoinColumn(name = "pays_id", nullable = false)
    private Pays pays;

    @ManyToOne
    @JoinColumn(name = "profession_id", nullable = false)
    private Professions profession;

    @ManyToOne
    @JoinColumn(name = "serie_bac_id", nullable = false)
    private SerieBac serieBac;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    private String candidatToken;
    private Integer anneeBac;
    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandidatsModules> candidatsModules = new ArrayList<>();

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandidatsCycles> candidatsCycles = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
//    // Nouvelle colonne ajoutée
//    private String etat;
//
//    private String justificationUn;
//    private String justificationDeux;
//    private String justificationTrois;
//    private String justificationQuatre;
//    private String justificationCinq;
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
