package com.example.backend.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "universites")
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @Column(name = "intitule_ar")
    private String intituleAr;

    @Column(name = "intitule_fr")
    private String intituleFr;

    private Boolean active;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "universite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Etablissement> etablissements = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public void addEtablissement(Etablissement etablissement) {
        etablissements.add(etablissement);
        etablissement.setUniversite(this);
    }

    public void removeEtablissement(Etablissement etablissement) {
        etablissements.remove(etablissement);
        etablissement.setUniversite(null);
    }
}
