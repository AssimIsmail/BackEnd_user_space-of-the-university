package com.example.backend.repository;

import com.example.backend.model.EtablissementsCycles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementsCyclesRepository extends JpaRepository<EtablissementsCycles, Long> {
}
