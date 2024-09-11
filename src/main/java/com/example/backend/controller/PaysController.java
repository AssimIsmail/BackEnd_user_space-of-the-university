package com.example.backend.controller;

import com.example.backend.dto.PaysDTO;
import com.example.backend.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pays")
public class PaysController {

    @Autowired
    private PaysService paysService;

    @PostMapping
    public ResponseEntity<PaysDTO> create(@RequestBody PaysDTO paysDTO) {
        return new ResponseEntity<>(paysService.create(paysDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaysDTO> getById(@PathVariable Long id) {
        PaysDTO pays = paysService.getById(id);
        return pays != null ? ResponseEntity.ok(pays) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PaysDTO>> getAll() {
        return ResponseEntity.ok(paysService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaysDTO> update(@PathVariable Long id, @RequestBody PaysDTO paysDTO) {
        PaysDTO updatedPays = paysService.update(id, paysDTO);
        return updatedPays != null ? ResponseEntity.ok(updatedPays) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paysService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
