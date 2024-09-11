package com.example.backend.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "cycles")
public class Cycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "intitule_fr")
    private String intituleFr;

    @Column(name = "intitule_ar")
    private String intituleAr;

    private String code;

    @Column(name = "nbr_filieres")
    private Integer nbrFilieres;

    @Column(name = "annee_univ")
    private String anneeUniv;

    @Column(name = "date_debut")
    private LocalDateTime dateDebut;

    @Column(name = "date_fin")
    private LocalDateTime dateFin;

    private Boolean active;

    @Column(name = "id_anneeuni")
    private Long idAnneeUni;

    private String piece;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "token_cycle")
    private String tokenCycle;

    @Column(name = "type_cycle")
    private String typeCycle;

    @OneToMany(mappedBy = "cycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Filiere> filieres = new HashSet<>();

    @OneToMany(mappedBy = "cycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CandidatsCycles> candidatsCycles = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_anneeuni", insertable = false, updatable = false)
    private AnneeUniversitaire anneeUniversitaire;
    @OneToMany(mappedBy = "cycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CyclesDiplomes> cyclesDiplomes = new HashSet<>();

    @OneToMany(mappedBy = "cycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EtablissementsCycles> etablissementsCycles = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
