    package com.example.backend.model;

    import lombok.Data;
    import jakarta.persistence.*;
    import java.time.LocalDateTime;
    import java.util.HashSet;
    import java.util.Set;

    @Data
    @Entity
    @Table(name = "pays")
    public class Pays {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String code;

        @Column(name = "intitule_ar")
        private String intituleAr;

        @Column(name = "intitule_fr")
        private String intituleFr;

        private String alpha2;

        private String alpha3;

        @Column(name = "created_at", updatable = false)
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        @Column(name = "deleted_at")
        private LocalDateTime deletedAt;

        @OneToMany(mappedBy = "pays", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Ville> villes = new HashSet<>();
        @OneToMany(mappedBy = "pays", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Candidat> candidats = new HashSet<>();

        @PrePersist
        protected void onCreate() {
            createdAt = LocalDateTime.now();
            updatedAt = LocalDateTime.now();
        }

        @PreUpdate
        protected void onUpdate() {
            updatedAt = LocalDateTime.now();
        }

        public void addVille(Ville ville) {
            villes.add(ville);
            ville.setPays(this);
        }

        public void removeVille(Ville ville) {
            villes.remove(ville);
            ville.setPays(null);
        }
    }
