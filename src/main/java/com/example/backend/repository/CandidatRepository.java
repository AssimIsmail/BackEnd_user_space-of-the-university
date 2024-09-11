package com.example.backend.repository;

import com.example.backend.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici
}
