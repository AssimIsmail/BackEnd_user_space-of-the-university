package com.example.backend.controller;

import com.example.backend.dto.DiplomeDTO;
import com.example.backend.service.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diplomes")
public class DiplomeController {

    @Autowired
    private DiplomeService diplomeService;

    @PostMapping
    public ResponseEntity<DiplomeDTO> create(@RequestBody DiplomeDTO dto) {
        return new ResponseEntity<>(diplomeService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiplomeDTO> getById(@PathVariable Long id) {
        DiplomeDTO dto = diplomeService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DiplomeDTO>> getAll() {
        return ResponseEntity.ok(diplomeService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiplomeDTO> update(@PathVariable Long id, @RequestBody DiplomeDTO dto) {
        DiplomeDTO updatedDto = diplomeService.update(id, dto);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        diplomeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
