package com.example.backend.controller;

import com.example.backend.dto.CandidatCycleDTO;
import com.example.backend.service.CandidatsCyclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidats-cycles")
public class CandidatsCyclesController {

    @Autowired
    private CandidatsCyclesService candidatsCyclesService;

    @PostMapping
    public ResponseEntity<CandidatCycleDTO> createCandidatsCycle(@RequestBody CandidatCycleDTO dto) {
        CandidatCycleDTO created = candidatsCyclesService.createCandidatsCycle(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidatCycleDTO> updateCandidatsCycle(
            @PathVariable Long id,
            @RequestBody CandidatCycleDTO dto) {
        CandidatCycleDTO updated = candidatsCyclesService.updateCandidatsCycle(id, dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatCycleDTO> getCandidatsCycle(@PathVariable Long id) {
        CandidatCycleDTO dto = candidatsCyclesService.getCandidatsCycle(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CandidatCycleDTO>> getAllCandidatsCycles() {
        List<CandidatCycleDTO> dtos = candidatsCyclesService.getAllCandidatsCycles();
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidatsCycle(@PathVariable Long id) {
        candidatsCyclesService.deleteCandidatsCycle(id);
        return ResponseEntity.noContent().build();
    }
}
