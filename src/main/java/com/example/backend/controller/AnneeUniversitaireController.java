package com.example.backend.controller;

import com.example.backend.dto.AnneeUniversitaireDTO;
import com.example.backend.service.AnneeUniversitaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/annee-universitaires")
public class AnneeUniversitaireController {

    @Autowired
    private AnneeUniversitaireService anneeUniversitaireService;

    @PostMapping
    public ResponseEntity<AnneeUniversitaireDTO> create(@RequestBody AnneeUniversitaireDTO dto) {
        return new ResponseEntity<>(anneeUniversitaireService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnneeUniversitaireDTO> getById(@PathVariable Long id) {
        AnneeUniversitaireDTO dto = anneeUniversitaireService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AnneeUniversitaireDTO>> getAll() {
        return ResponseEntity.ok(anneeUniversitaireService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnneeUniversitaireDTO> update(@PathVariable Long id, @RequestBody AnneeUniversitaireDTO dto) {
        AnneeUniversitaireDTO updatedDto = anneeUniversitaireService.update(id, dto);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        anneeUniversitaireService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
