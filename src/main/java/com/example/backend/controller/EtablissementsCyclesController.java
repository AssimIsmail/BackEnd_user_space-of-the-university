package com.example.backend.controller;

import com.example.backend.dto.EtablissementsCyclesDTO;
import com.example.backend.service.EtablissementsCyclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etablissements-cycles")
public class EtablissementsCyclesController {

    @Autowired
    private EtablissementsCyclesService etablissementsCyclesService;

    @PostMapping
    public ResponseEntity<EtablissementsCyclesDTO> createEtablissementsCycles(@RequestBody EtablissementsCyclesDTO dto) {
        return ResponseEntity.ok(etablissementsCyclesService.createEtablissementsCycles(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtablissementsCyclesDTO> updateEtablissementsCycles(@PathVariable Long id, @RequestBody EtablissementsCyclesDTO dto) {
        return ResponseEntity.ok(etablissementsCyclesService.updateEtablissementsCycles(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtablissementsCyclesDTO> getEtablissementsCycles(@PathVariable Long id) {
        EtablissementsCyclesDTO dto = etablissementsCyclesService.getEtablissementsCycles(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EtablissementsCyclesDTO>> getAllEtablissementsCycles() {
        return ResponseEntity.ok(etablissementsCyclesService.getAllEtablissementsCycles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtablissementsCycles(@PathVariable Long id) {
        etablissementsCyclesService.deleteEtablissementsCycles(id);
        return ResponseEntity.noContent().build();
    }
}
