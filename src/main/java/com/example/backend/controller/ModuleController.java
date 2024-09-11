package com.example.backend.controller;

import com.example.backend.dto.ModuleDTO;
import com.example.backend.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping
    public ResponseEntity<ModuleDTO> create(@RequestBody ModuleDTO dto) {
        return new ResponseEntity<>(moduleService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDTO> getById(@PathVariable Long id) {
        ModuleDTO dto = moduleService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ModuleDTO>> getAll() {
        return ResponseEntity.ok(moduleService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleDTO> update(@PathVariable Long id, @RequestBody ModuleDTO dto) {
        ModuleDTO updatedDto = moduleService.update(id, dto);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        moduleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
