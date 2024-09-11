package com.example.backend.service;

import com.example.backend.dto.UniversiteDTO;
import com.example.backend.mapper.UniversiteMapper;
import com.example.backend.model.Universite;
import com.example.backend.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

    private final UniversiteMapper universiteMapper = UniversiteMapper.INSTANCE;

    public UniversiteDTO create(UniversiteDTO universiteDTO) {
        Universite universite = universiteMapper.toEntity(universiteDTO);
        universite.setCreatedAt(LocalDateTime.now());
        universite.setUpdatedAt(LocalDateTime.now());
        return universiteMapper.toDTO(universiteRepository.save(universite));
    }

    public UniversiteDTO getById(Long id) {
        Optional<Universite> universite = universiteRepository.findById(id);
        return universite.map(universiteMapper::toDTO).orElse(null);
    }

    public List<UniversiteDTO> getAll() {
        return universiteRepository.findAll().stream()
                .map(universiteMapper::toDTO)
                .toList();
    }

    public UniversiteDTO update(Long id, UniversiteDTO universiteDTO) {
        if (universiteRepository.existsById(id)) {
            Universite universite = universiteMapper.toEntity(universiteDTO);
            universite.setId(id);
            universite.setUpdatedAt(LocalDateTime.now());
            return universiteMapper.toDTO(universiteRepository.save(universite));
        }
        return null;
    }

//    public void delete(Long id) {
//        if (universiteRepository.existsById(id)) {
//            Universite universite = universiteRepository.findById(id).orElse(null);
//            if (universite != null) {
//                universite.setDeletedAt(LocalDateTime.now());
//                universiteRepository.save(universite);
//            }
//        }
//    }
public void delete(Long id) {
    if (universiteRepository.existsById(id)) {
        universiteRepository.deleteById(id);
    }
}
}
