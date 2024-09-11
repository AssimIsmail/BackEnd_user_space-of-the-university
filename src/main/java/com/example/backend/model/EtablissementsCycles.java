package com.example.backend.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "etablissements_cycles")
public class EtablissementsCycles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_etablissement_choix")
    private Long idEtablissementChoix;

    @Column(name = "id_cycle")
    private Long idCycle;

    @Column(name = "id_annee")
    private Long idAnnee;

    @Column(name = "nbr_choix")
    private Integer nbrChoix;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etablissement_choix", insertable = false, updatable = false)
    private EtablissementChoix etablissementChoix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cycle", insertable = false, updatable = false)
    private Cycle cycle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_annee", insertable = false, updatable = false)
    private AnneeUniversitaire anneeUniversitaire;

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
