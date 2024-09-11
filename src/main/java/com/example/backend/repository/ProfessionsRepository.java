package com.example.backend.repository;

import com.example.backend.model.Professions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionsRepository extends JpaRepository<Professions, Long> {
}
