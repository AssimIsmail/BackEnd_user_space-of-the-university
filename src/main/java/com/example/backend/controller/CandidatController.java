package com.example.backend.controller;

import com.example.backend.dto.CandidatDTO;
import com.example.backend.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidats")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @PutMapping("/{id}")
    public ResponseEntity<CandidatDTO> updateCandidat(
            @PathVariable Long id,
            @RequestBody CandidatDTO candidatDTO) {

        try {
            CandidatDTO updatedCandidat = candidatService.updateCandidat(id, candidatDTO);
            return ResponseEntity.ok(updatedCandidat);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // Or handle error more gracefully
        }
    }

    @PostMapping
    public ResponseEntity<CandidatDTO> createCandidat(@RequestBody CandidatDTO candidatDTO) {
        CandidatDTO createdCandidat = candidatService.saveCandidat(candidatDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCandidat);
    }

    @GetMapping
    public List<CandidatDTO> getAllCandidats() {
        return candidatService.getAllCandidats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatDTO> getCandidatById(@PathVariable Long id) {
        return candidatService.getCandidatById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable Long id) {
        candidatService.deleteCandidat(id);
        return ResponseEntity.noContent().build();
    }
}
