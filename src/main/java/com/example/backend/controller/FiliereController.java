package com.example.backend.controller;

import com.example.backend.dto.FiliereDTO;
import com.example.backend.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @PostMapping
    public ResponseEntity<FiliereDTO> create(@RequestBody FiliereDTO dto) {
        return new ResponseEntity<>(filiereService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FiliereDTO> getById(@PathVariable Long id) {
        FiliereDTO dto = filiereService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<FiliereDTO>> getAll() {
        return ResponseEntity.ok(filiereService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FiliereDTO> update(@PathVariable Long id, @RequestBody FiliereDTO dto) {
        FiliereDTO updatedDto = filiereService.update(id, dto);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filiereService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
