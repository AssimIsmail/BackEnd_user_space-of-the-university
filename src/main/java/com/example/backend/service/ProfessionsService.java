package com.example.backend.service;

import com.example.backend.dto.ProfessionsDTO;
import com.example.backend.mapper.ProfessionsMapper;
import com.example.backend.model.Professions;
import com.example.backend.repository.ProfessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessionsService {

    @Autowired
    private ProfessionsRepository professionsRepository;

    @Autowired
    private ProfessionsMapper professionsMapper;
    public Professions fetchProfessionById(Long id) {
        return professionsRepository.findById(id).orElse(null);
    }
    public ProfessionsDTO create(ProfessionsDTO professionsDTO) {
        Professions professions = professionsMapper.toEntity(professionsDTO);
        professions.setCreatedAt(LocalDateTime.now());
        professions.setUpdatedAt(LocalDateTime.now());
        return professionsMapper.toDTO(professionsRepository.save(professions));
    }

    public ProfessionsDTO getById(Long id) {
        Optional<Professions> professions = professionsRepository.findById(id);
        return professions.map(professionsMapper::toDTO).orElse(null);
    }

    public List<ProfessionsDTO> getAll() {
        return professionsRepository.findAll().stream()
                .map(professionsMapper::toDTO)
                .toList();
    }

    public ProfessionsDTO update(Long id, ProfessionsDTO professionsDTO) {
        if (professionsRepository.existsById(id)) {
            Professions professions = professionsMapper.toEntity(professionsDTO);
            professions.setId(id);
            professions.setUpdatedAt(LocalDateTime.now());
            return professionsMapper.toDTO(professionsRepository.save(professions));
        }
        return null;
    }

//    public void delete(Long id) {
//        if (professionsRepository.existsById(id)) {
//            Professions professions = professionsRepository.findById(id).orElse(null);
//            if (professions != null) {
//                professions.setDeletedAt(LocalDateTime.now());
//                professionsRepository.save(professions);
//            }
//        }
//    }
public void delete(Long id) {
    if (professionsRepository.existsById(id)) {
        professionsRepository.deleteById(id);
    }
}
}
