package com.example.backend.controller;

import com.example.backend.dto.SerieBacDTO;
import com.example.backend.service.SerieBacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serie-bacs")
public class SerieBacController {

    @Autowired
    private SerieBacService serieBacService;

    @PostMapping
    public ResponseEntity<SerieBacDTO> create(@RequestBody SerieBacDTO serieBacDTO) {
        return new ResponseEntity<>(serieBacService.create(serieBacDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieBacDTO> getById(@PathVariable Long id) {
        SerieBacDTO serieBac = serieBacService.getById(id);
        return serieBac != null ? ResponseEntity.ok(serieBac) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<SerieBacDTO>> getAll() {
        return ResponseEntity.ok(serieBacService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SerieBacDTO> update(@PathVariable Long id, @RequestBody SerieBacDTO serieBacDTO) {
        SerieBacDTO updatedSerieBac = serieBacService.update(id, serieBacDTO);
        return updatedSerieBac != null ? ResponseEntity.ok(updatedSerieBac) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serieBacService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
