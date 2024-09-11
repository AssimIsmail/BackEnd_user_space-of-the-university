package com.example.backend.repository;

import com.example.backend.model.Critere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CritereRepository extends JpaRepository<Critere, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}
