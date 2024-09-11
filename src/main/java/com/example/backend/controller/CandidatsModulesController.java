package com.example.backend.controller;

import com.example.backend.dto.CandidatsModulesDTO;
import com.example.backend.service.CandidatsModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidats-modules")
public class CandidatsModulesController {

    @Autowired
    private CandidatsModulesService candidatsModulesService;

    @PostMapping
    public ResponseEntity<CandidatsModulesDTO> createCandidatsModules(@RequestBody CandidatsModulesDTO dto) {
        CandidatsModulesDTO createdDTO = candidatsModulesService.createCandidatsModules(dto);
        return ResponseEntity.ok(createdDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidatsModulesDTO> updateCandidatsModules(
            @PathVariable Long id,
            @RequestBody CandidatsModulesDTO dto) {
        CandidatsModulesDTO updatedDTO = candidatsModulesService.updateCandidatsModules(id, dto);
        return ResponseEntity.ok(updatedDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatsModulesDTO> getCandidatsModules(@PathVariable Long id) {
        CandidatsModulesDTO dto = candidatsModulesService.getCandidatsModules(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidatsModules(@PathVariable Long id) {
        candidatsModulesService.deleteCandidatsModules(id);
        return ResponseEntity.noContent().build();
    }
}
