package com.example.backend.controller;

import com.example.backend.dto.ParamsDTO;
import com.example.backend.service.ParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/params")
public class ParamsController {

    @Autowired
    private ParamsService paramsService;

    @PostMapping
    public ResponseEntity<ParamsDTO> create(@RequestBody ParamsDTO paramsDTO) {
        return new ResponseEntity<>(paramsService.create(paramsDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParamsDTO> getById(@PathVariable Long id) {
        ParamsDTO params = paramsService.getById(id);
        return params != null ? ResponseEntity.ok(params) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ParamsDTO>> getAll() {
        return ResponseEntity.ok(paramsService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParamsDTO> update(@PathVariable Long id, @RequestBody ParamsDTO paramsDTO) {
        ParamsDTO updatedParams = paramsService.update(id, paramsDTO);
        return updatedParams != null ? ResponseEntity.ok(updatedParams) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paramsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
