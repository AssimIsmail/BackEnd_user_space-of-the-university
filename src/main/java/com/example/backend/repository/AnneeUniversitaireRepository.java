package com.example.backend.repository;

import com.example.backend.model.AnneeUniversitaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnneeUniversitaireRepository extends JpaRepository<AnneeUniversitaire, Long> {
    boolean existsById(Long id);
    List<AnneeUniversitaire> findAll();
}

