package com.example.backend.controller;

import com.example.backend.dto.UniversiteDTO;
import com.example.backend.service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    @Autowired
    private UniversiteService universiteService;

    @PostMapping
    public ResponseEntity<UniversiteDTO> create(@RequestBody UniversiteDTO universiteDTO) {
        return new ResponseEntity<>(universiteService.create(universiteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversiteDTO> getById(@PathVariable Long id) {
        UniversiteDTO universite = universiteService.getById(id);
        return universite != null ? ResponseEntity.ok(universite) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<UniversiteDTO>> getAll() {
        return ResponseEntity.ok(universiteService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversiteDTO> update(@PathVariable Long id, @RequestBody UniversiteDTO universiteDTO) {
        UniversiteDTO updatedUniversite = universiteService.update(id, universiteDTO);
        return updatedUniversite != null ? ResponseEntity.ok(updatedUniversite) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        universiteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
