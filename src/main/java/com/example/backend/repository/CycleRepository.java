package com.example.backend.repository;

import com.example.backend.model.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}
