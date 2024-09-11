package com.example.backend.service;

import com.example.backend.dto.CycleDTO;
import com.example.backend.mapper.CycleMapper;
import com.example.backend.model.Cycle;
import com.example.backend.model.Diplome;
import com.example.backend.repository.CycleRepository;
import com.example.backend.repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CycleService {

    @Autowired
    private CycleRepository cycleRepository;

    @Autowired
    private CycleMapper cycleMapper;
    @Autowired
    private DiplomeRepository diplomeRepository;

    public Optional<Cycle> findById(Long id) {
        return cycleRepository.findById(id);
    }

    public List<CycleDTO> getAllCycles() {
        List<Cycle> cycles = cycleRepository.findAll();
        return cycles.stream()
                .map(cycleMapper::toDTO)
                .toList();
    }

    public CycleDTO getCycleById(Long id) {
        Optional<Cycle> cycle = cycleRepository.findById(id);
        return cycle.map(cycleMapper::toDTO).orElse(null);
    }
    public Cycle getCycleEntityById(Long id) {
        Optional<Cycle> cycle = cycleRepository.findById(id);
        return cycle.orElse(null);
    }

    public CycleDTO createCycle(CycleDTO cycleDTO) {
        Cycle cycle = cycleMapper.toEntity(cycleDTO);
        Cycle savedCycle = cycleRepository.save(cycle);
        return cycleMapper.toDTO(savedCycle);
    }

    public CycleDTO updateCycle(Long id, CycleDTO cycleDTO) {
        if (!cycleRepository.existsById(id)) {
            return null; // Or throw an exception if preferred
        }
        Cycle cycle = cycleMapper.toEntity(cycleDTO);
        cycle.setId(id);
        Cycle updatedCycle = cycleRepository.save(cycle);
        return cycleMapper.toDTO(updatedCycle);
    }

    public void deleteCycle(Long id) {
        if (cycleRepository.existsById(id)) {
            cycleRepository.deleteById(id);
        }
        // Or throw an exception if preferred
    }

}
