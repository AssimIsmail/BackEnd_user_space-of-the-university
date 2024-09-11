package com.example.backend.controller;

import com.example.backend.dto.VilleDTO;
import com.example.backend.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/villes")
public class VilleController {

    @Autowired
    private VilleService villeService;

    @PostMapping
    public ResponseEntity<VilleDTO> create(@RequestBody VilleDTO villeDTO) {
        return new ResponseEntity<>(villeService.create(villeDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VilleDTO> getById(@PathVariable Long id) {
        VilleDTO ville = villeService.getById(id);
        return ville != null ? ResponseEntity.ok(ville) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<VilleDTO>> getAll() {
        return ResponseEntity.ok(villeService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VilleDTO> update(@PathVariable Long id, @RequestBody VilleDTO villeDTO) {
        VilleDTO updatedVille = villeService.update(id, villeDTO);
        return updatedVille != null ? ResponseEntity.ok(updatedVille) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        villeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
