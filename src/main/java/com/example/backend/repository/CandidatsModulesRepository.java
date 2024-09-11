package com.example.backend.repository;

import com.example.backend.model.CandidatsModules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatsModulesRepository extends JpaRepository<CandidatsModules, Long> {
}
