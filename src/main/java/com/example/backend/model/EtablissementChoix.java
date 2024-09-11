package com.example.backend.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "etablissements_choix")
public class EtablissementChoix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "token_etablissement_choix")
    private String tokenEtablissementChoix;

    @OneToMany(mappedBy = "etablissementChoix", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Filiere> filieres = new ArrayList<>();

    @OneToMany(mappedBy = "etablissementChoix", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public void addFiliere(Filiere filiere) {
        filieres.add(filiere);
        filiere.setEtablissementChoix(this);
    }

    public void removeFiliere(Filiere filiere) {
        filieres.remove(filiere);
        filiere.setEtablissementChoix(null);
    }

}
