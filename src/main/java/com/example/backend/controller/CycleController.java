package com.example.backend.controller;

import com.example.backend.dto.CycleDTO;
import com.example.backend.service.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cycles")
public class CycleController {

    @Autowired
    private CycleService cycleService;

    @GetMapping
    public ResponseEntity<List<CycleDTO>> getAllCycles() {
        List<CycleDTO> cycles = cycleService.getAllCycles();
        return ResponseEntity.ok(cycles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CycleDTO> getCycleById(@PathVariable Long id) {
        CycleDTO cycleDTO = cycleService.getCycleById(id);
        if (cycleDTO != null) {
            return ResponseEntity.ok(cycleDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CycleDTO> createCycle(@RequestBody CycleDTO cycleDTO) {
        CycleDTO createdCycle = cycleService.createCycle(cycleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCycle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CycleDTO> updateCycle(@PathVariable Long id, @RequestBody CycleDTO cycleDTO) {
        CycleDTO updatedCycle = cycleService.updateCycle(id, cycleDTO);
        if (updatedCycle != null) {
            return ResponseEntity.ok(updatedCycle);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCycle(@PathVariable Long id) {
        cycleService.deleteCycle(id);
        return ResponseEntity.noContent().build();
    }
}
