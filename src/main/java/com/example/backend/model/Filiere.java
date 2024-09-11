package com.example.backend.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "filieres")
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "intitule_fr")
    private String intituleFr;

    @Column(name = "intitule_ar")
    private String intituleAr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cycle")
    private Cycle cycle; // Nouvelle relation ManyToOne avec Cycle

    private String etat;

    private String code;

    @Column(name = "type_filiere")
    private String typeFiliere;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "token_filiere")
    private String tokenFiliere;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etablissement_choix")
    private EtablissementChoix etablissementChoix;
    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Module> modules = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Critere> criteres = new ArrayList<>();
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
