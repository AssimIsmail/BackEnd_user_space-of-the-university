package com.example.backend.repository;

import com.example.backend.model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {

    // Custom query to exclude deleted entries
    List<Pays> findByDeletedAtIsNull();
}
