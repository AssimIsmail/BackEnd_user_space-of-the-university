package com.example.backend.service;

import com.example.backend.dto.ModuleDTO;
import com.example.backend.mapper.ModuleMapper;
import com.example.backend.model.Module;
import com.example.backend.model.Filiere;
import com.example.backend.repository.ModuleRepository;
import com.example.backend.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private FiliereRepository filiereRepository;

    private final ModuleMapper moduleMapper = ModuleMapper.INSTANCE;

    public ModuleDTO create(ModuleDTO dto) {
        validateFiliere(dto.getIdFiliere()); // Vérifier l'existence de Filiere

        Module module = moduleMapper.toEntity(dto);
        module.setCreatedAt(LocalDateTime.now());
        module.setUpdatedAt(LocalDateTime.now());
        return moduleMapper.toDTO(moduleRepository.save(module));
    }

    public ModuleDTO getById(Long id) {
        Optional<Module> module = moduleRepository.findById(id);
        return module.map(moduleMapper::toDTO).orElse(null);
    }

    public List<ModuleDTO> getAll() {
        List<Module> modules = moduleRepository.findAll();
        return modules.stream()
                .map(moduleMapper::toDTO)
                .toList();
    }

    public ModuleDTO update(Long id, ModuleDTO dto) {
        if (!moduleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Module with ID " + id + " does not exist.");
        }

        validateFiliere(dto.getIdFiliere()); // Vérifier l'existence de Filiere

        Module module = moduleMapper.toEntity(dto);
        module.setId(id);
        module.setUpdatedAt(LocalDateTime.now());
        return moduleMapper.toDTO(moduleRepository.save(module));
    }

    public void delete(Long id) {
        if (moduleRepository.existsById(id)) {
            moduleRepository.deleteById(id); // Suppression physique
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Module with ID " + id + " does not exist.");
        }
    }

    private void validateFiliere(Long filiereId) {
        if (filiereId != null && !filiereRepository.existsById(filiereId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filiere with ID " + filiereId + " does not exist.");
        }
    }
}
