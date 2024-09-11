package com.example.backend.controller;

import com.example.backend.dto.ProfessionsDTO;
import com.example.backend.service.ProfessionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professions")
public class ProfessionsController {

    @Autowired
    private ProfessionsService professionsService;

    @PostMapping
    public ResponseEntity<ProfessionsDTO> create(@RequestBody ProfessionsDTO professionsDTO) {
        return new ResponseEntity<>(professionsService.create(professionsDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionsDTO> getById(@PathVariable Long id) {
        ProfessionsDTO professions = professionsService.getById(id);
        return professions != null ? ResponseEntity.ok(professions) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ProfessionsDTO>> getAll() {
        return ResponseEntity.ok(professionsService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionsDTO> update(@PathVariable Long id, @RequestBody ProfessionsDTO professionsDTO) {
        ProfessionsDTO updatedProfessions = professionsService.update(id, professionsDTO);
        return updatedProfessions != null ? ResponseEntity.ok(updatedProfessions) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professionsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
