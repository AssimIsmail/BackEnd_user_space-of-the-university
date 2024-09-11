package com.example.backend.controller;

import com.example.backend.dto.CyclesDiplomesDTO;
import com.example.backend.service.CyclesDiplomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cycles-diplomes")
public class CyclesDiplomesController {

    @Autowired
    private CyclesDiplomesService cyclesDiplomesService;

    @PostMapping
    public ResponseEntity<CyclesDiplomesDTO> createCyclesDiplomes(@RequestBody CyclesDiplomesDTO dto) {
        return ResponseEntity.ok(cyclesDiplomesService.createCyclesDiplomes(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CyclesDiplomesDTO> updateCyclesDiplomes(@PathVariable Long id, @RequestBody CyclesDiplomesDTO dto) {
        return ResponseEntity.ok(cyclesDiplomesService.updateCyclesDiplomes(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CyclesDiplomesDTO> getCyclesDiplomes(@PathVariable Long id) {
        CyclesDiplomesDTO dto = cyclesDiplomesService.getCyclesDiplomes(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CyclesDiplomesDTO>> getAllCyclesDiplomes() {
        return ResponseEntity.ok(cyclesDiplomesService.getAllCyclesDiplomes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCyclesDiplomes(@PathVariable Long id) {
        cyclesDiplomesService.deleteCyclesDiplomes(id);
        return ResponseEntity.noContent().build();
    }
}
