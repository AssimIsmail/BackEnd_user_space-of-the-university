package com.example.backend.controller;

import com.example.backend.dto.CritereDTO;
import com.example.backend.service.CritereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/criteres")
public class CritereController {

    @Autowired
    private CritereService critereService;

    @GetMapping
    public ResponseEntity<List<CritereDTO>> getAllCriteres() {
        List<CritereDTO> criteres = critereService.getAllCriteres();
        return ResponseEntity.ok(criteres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CritereDTO> getCritereById(@PathVariable Long id) {
        CritereDTO critere = critereService.getCritereById(id);
        if (critere == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(critere);
    }

    @PostMapping
    public ResponseEntity<CritereDTO> createCritere(@RequestBody CritereDTO critereDTO) {
        CritereDTO createdCritere = critereService.createCritere(critereDTO);
        return ResponseEntity.ok(createdCritere);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CritereDTO> updateCritere(@PathVariable Long id, @RequestBody CritereDTO critereDTO) {
        CritereDTO updatedCritere = critereService.updateCritere(id, critereDTO);
        if (updatedCritere == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCritere);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCritere(@PathVariable Long id) {
        critereService.deleteCritere(id);
        return ResponseEntity.noContent().build();
    }
}
