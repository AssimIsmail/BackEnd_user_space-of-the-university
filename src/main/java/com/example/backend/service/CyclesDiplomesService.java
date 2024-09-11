package com.example.backend.service;

import com.example.backend.dto.CyclesDiplomesDTO;
import com.example.backend.mapper.CyclesDiplomesMapper;
import com.example.backend.model.Cycle;
import com.example.backend.model.CyclesDiplomes;
import com.example.backend.model.Diplome;
import com.example.backend.repository.CycleRepository;
import com.example.backend.repository.CyclesDiplomesRepository;
import com.example.backend.repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CyclesDiplomesService {

    @Autowired
    private CyclesDiplomesRepository cyclesDiplomesRepository;

    @Autowired
    private CycleRepository cycleRepository;

    @Autowired
    private DiplomeRepository diplomeRepository;

    @Autowired
    private CyclesDiplomesMapper cyclesDiplomesMapper;

    public CyclesDiplomesDTO createCyclesDiplomes(CyclesDiplomesDTO dto) {
        Optional<Cycle> cycle = cycleRepository.findById(dto.getCycleId());
        Optional<Diplome> diplome = diplomeRepository.findById(dto.getDiplomeId());

        if (cycle.isPresent() && diplome.isPresent()) {
            CyclesDiplomes cyclesDiplomes = cyclesDiplomesMapper.fromDTO(dto, cycle.get(), diplome.get());
            cyclesDiplomes = cyclesDiplomesRepository.save(cyclesDiplomes);
            return cyclesDiplomesMapper.toDTO(cyclesDiplomes);
        } else {
            throw new IllegalArgumentException("Cycle or Diplome not found");
        }
    }

    public CyclesDiplomesDTO updateCyclesDiplomes(Long id, CyclesDiplomesDTO dto) {
        Optional<CyclesDiplomes> existing = cyclesDiplomesRepository.findById(id);
        if (existing.isPresent()) {
            Optional<Cycle> cycle = cycleRepository.findById(dto.getCycleId());
            Optional<Diplome> diplome = diplomeRepository.findById(dto.getDiplomeId());

            if (cycle.isPresent() && diplome.isPresent()) {
                CyclesDiplomes cyclesDiplomes = existing.get();
                cyclesDiplomes.setCycle(cycle.get());
                cyclesDiplomes.setDiplome(diplome.get());
                cyclesDiplomes.setCreatedAt(dto.getCreatedAt());
                cyclesDiplomes.setUpdatedAt(dto.getUpdatedAt());
                cyclesDiplomes.setDeletedAt(dto.getDeletedAt());
                cyclesDiplomes = cyclesDiplomesRepository.save(cyclesDiplomes);
                return cyclesDiplomesMapper.toDTO(cyclesDiplomes);
            } else {
                throw new IllegalArgumentException("Cycle or Diplome not found");
            }
        } else {
            throw new IllegalArgumentException("CyclesDiplomes not found");
        }
    }

    public CyclesDiplomesDTO getCyclesDiplomes(Long id) {
        Optional<CyclesDiplomes> cyclesDiplomes = cyclesDiplomesRepository.findById(id);
        return cyclesDiplomes.map(cyclesDiplomesMapper::toDTO).orElse(null);
    }

    public List<CyclesDiplomesDTO> getAllCyclesDiplomes() {
        return cyclesDiplomesRepository.findAll().stream()
                .map(cyclesDiplomesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteCyclesDiplomes(Long id) {
        cyclesDiplomesRepository.deleteById(id);
    }
}
