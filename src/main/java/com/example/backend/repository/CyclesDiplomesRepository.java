package com.example.backend.repository;

import com.example.backend.model.CyclesDiplomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclesDiplomesRepository extends JpaRepository<CyclesDiplomes, Long> {
}
