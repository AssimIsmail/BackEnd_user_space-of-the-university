package com.example.backend.service;

import com.example.backend.dto.DiplomeDTO;
import com.example.backend.mapper.DiplomeMapper;
import com.example.backend.model.Cycle;
import com.example.backend.model.Diplome;
import com.example.backend.repository.CycleRepository;
import com.example.backend.repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DiplomeService {

    @Autowired
    private DiplomeRepository diplomeRepository;
    @Autowired
    private CycleRepository cycleRepository;
    private final DiplomeMapper diplomeMapper = DiplomeMapper.INSTANCE;

    public DiplomeDTO create(DiplomeDTO dto) {
        Diplome diplome = diplomeMapper.toEntity(dto);
        diplome.setCreatedAt(LocalDateTime.now());
        diplome.setUpdatedAt(LocalDateTime.now());
        return diplomeMapper.toDTO(diplomeRepository.save(diplome));
    }

    public DiplomeDTO getById(Long id) {
        Optional<Diplome> diplome = diplomeRepository.findById(id);
        return diplome.map(diplomeMapper::toDTO).orElse(null);
    }

    public List<DiplomeDTO> getAll() {
        return diplomeRepository.findAll().stream()
                .map(diplomeMapper::toDTO)
                .toList();
    }

    public DiplomeDTO update(Long id, DiplomeDTO dto) {
        if (diplomeRepository.existsById(id)) {
            Diplome diplome = diplomeMapper.toEntity(dto);
            diplome.setId(id);
            diplome.setUpdatedAt(LocalDateTime.now());
            return diplomeMapper.toDTO(diplomeRepository.save(diplome));
        }
        return null;
    }

//    public void delete(Long id) {
//        if (diplomeRepository.existsById(id)) {
//            Diplome diplome = diplomeRepository.findById(id).orElse(null);
//            if (diplome != null) {
//                diplome.setDeletedAt(LocalDateTime.now());
//                diplomeRepository.save(diplome);
//            }
//        }
//    }
public void delete(Long id) {
    if (diplomeRepository.existsById(id)) {
        diplomeRepository.deleteById(id); // Suppression physique
    }
}
}
