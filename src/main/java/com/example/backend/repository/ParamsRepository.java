package com.example.backend.repository;

import com.example.backend.model.Params;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParamsRepository extends JpaRepository<Params, Long> {
}
