package com.example.backend.controller;

import com.example.backend.dto.EtablissementDTO;
import com.example.backend.service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etablissements")
public class EtablissementController {

    @Autowired
    private EtablissementService etablissementService;

    @GetMapping
    public ResponseEntity<List<EtablissementDTO>> getAllEtablissements() {
        List<EtablissementDTO> etablissements = etablissementService.getAllEtablissements();
        return ResponseEntity.ok(etablissements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtablissementDTO> getEtablissementById(@PathVariable Long id) {
        EtablissementDTO etablissement = etablissementService.getEtablissementById(id);
        if (etablissement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(etablissement);
    }

    @PostMapping
    public ResponseEntity<EtablissementDTO> createEtablissement(@RequestBody EtablissementDTO etablissementDTO) {
        EtablissementDTO createdEtablissement = etablissementService.createEtablissement(etablissementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEtablissement);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EtablissementDTO> updateEtablissement(@PathVariable Long id, @RequestBody EtablissementDTO etablissementDTO) {
        EtablissementDTO updatedEtablissement = etablissementService.updateEtablissement(id, etablissementDTO);
        if (updatedEtablissement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEtablissement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtablissement(@PathVariable Long id) {
        boolean deleted = etablissementService.deleteEtablissement(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
