package com.example.backend.controller;

import com.example.backend.dto.EtablissementChoixDTO;
import com.example.backend.service.EtablissementChoixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etablissements-choix")
public class EtablissementChoixController {

    @Autowired
    private EtablissementChoixService etablissementChoixService;

    @PostMapping
    public ResponseEntity<EtablissementChoixDTO> create(@RequestBody EtablissementChoixDTO dto) {
        return new ResponseEntity<>(etablissementChoixService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtablissementChoixDTO> getById(@PathVariable Long id) {
        EtablissementChoixDTO dto = etablissementChoixService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<EtablissementChoixDTO>> getAll() {
        return ResponseEntity.ok(etablissementChoixService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtablissementChoixDTO> update(@PathVariable Long id, @RequestBody EtablissementChoixDTO dto) {
        EtablissementChoixDTO updatedDto = etablissementChoixService.update(id, dto);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        etablissementChoixService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
