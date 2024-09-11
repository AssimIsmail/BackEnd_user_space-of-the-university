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
@Table(name = "annee_universitaires")
public class AnneeUniversitaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;

    private String etat;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    @OneToMany(mappedBy = "anneeUniversitaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandidatsCycles> candidatsCycles = new ArrayList<>();

    @OneToMany(mappedBy = "anneeUniversitaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cycle> cycles = new ArrayList<>();
    @OneToMany(mappedBy = "anneeUniversitaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandidatsModules> candidatsModules = new ArrayList<>();


    @OneToMany(mappedBy = "anneeUniversitaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EtablissementsCycles> etablissementsCycles = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }


    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Méthodes pour gérer les cycles
    public void addCycle(Cycle cycle) {
        cycles.add(cycle);
        cycle.setAnneeUniversitaire(this);
    }

    public void removeCycle(Cycle cycle) {
        cycles.remove(cycle);
        cycle.setAnneeUniversitaire(null);
    }
}
