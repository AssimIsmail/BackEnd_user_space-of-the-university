package com.example.backend.service;

import com.example.backend.dto.CritereDTO;
import com.example.backend.mapper.CritereMapper;
import com.example.backend.model.Critere;
import com.example.backend.repository.CritereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CritereService {

    @Autowired
    private CritereRepository critereRepository;

    @Autowired
    private CritereMapper critereMapper;

    public List<CritereDTO> getAllCriteres() {
        return critereRepository.findAll().stream()
                .map(critereMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CritereDTO getCritereById(Long id) {
        Optional<Critere> critere = critereRepository.findById(id);
        return critere.map(critereMapper::toDTO).orElse(null);
    }

    public CritereDTO createCritere(CritereDTO critereDTO) {
        Critere critere = critereMapper.toEntity(critereDTO);
        Critere savedCritere = critereRepository.save(critere);
        return critereMapper.toDTO(savedCritere);
    }

    public CritereDTO updateCritere(Long id, CritereDTO critereDTO) {
        if (!critereRepository.existsById(id)) {
            return null;
        }
        Critere critere = critereMapper.toEntity(critereDTO);
        critere.setId(id); // Assurez-vous de définir l'ID pour que la mise à jour soit effectuée
        Critere updatedCritere = critereRepository.save(critere);
        return critereMapper.toDTO(updatedCritere);
    }

    public void deleteCritere(Long id) {
        critereRepository.deleteById(id);
    }
}
