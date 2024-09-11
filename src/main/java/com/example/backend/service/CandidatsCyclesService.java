package com.example.backend.service;

import com.example.backend.dto.CandidatCycleDTO;
import com.example.backend.mapper.CandidatsCyclesMapper;
import com.example.backend.model.CandidatsCycles;
import com.example.backend.model.Candidat;
import com.example.backend.model.Cycle;
import com.example.backend.model.AnneeUniversitaire;
import com.example.backend.repository.CandidatsCyclesRepository;
import com.example.backend.repository.CandidatRepository;
import com.example.backend.repository.CycleRepository;
import com.example.backend.repository.AnneeUniversitaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidatsCyclesService {

    @Autowired
    private CandidatsCyclesRepository candidatsCyclesRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private CycleRepository cycleRepository;

    @Autowired
    private AnneeUniversitaireRepository anneeUniversitaireRepository;

    @Autowired
    private CandidatsCyclesMapper candidatsCyclesMapper;

    public CandidatCycleDTO createCandidatsCycle(CandidatCycleDTO dto) {
        Optional<Candidat> candidat = candidatRepository.findById(dto.getCandidatId());
        Optional<Cycle> cycle = cycleRepository.findById(dto.getCycleId());
        Optional<AnneeUniversitaire> anneeUniversitaire = anneeUniversitaireRepository.findById(dto.getAnneeUniversitaireId());

        if (candidat.isPresent() && cycle.isPresent() && anneeUniversitaire.isPresent()) {
            CandidatsCycles candidatsCycle = candidatsCyclesMapper.fromDTO(dto, candidat.get(), cycle.get(), anneeUniversitaire.get());
            candidatsCycle = candidatsCyclesRepository.save(candidatsCycle);
            return candidatsCyclesMapper.toDTO(candidatsCycle);
        } else {
            throw new IllegalArgumentException("Candidat, Cycle, or AnneeUniversitaire not found");
        }
    }

    public CandidatCycleDTO updateCandidatsCycle(Long id, CandidatCycleDTO dto) {
        Optional<CandidatsCycles> existing = candidatsCyclesRepository.findById(id);
        if (existing.isPresent()) {
            Optional<Candidat> candidat = candidatRepository.findById(dto.getCandidatId());
            Optional<Cycle> cycle = cycleRepository.findById(dto.getCycleId());
            Optional<AnneeUniversitaire> anneeUniversitaire = anneeUniversitaireRepository.findById(dto.getAnneeUniversitaireId());

            if (candidat.isPresent() && cycle.isPresent() && anneeUniversitaire.isPresent()) {
                CandidatsCycles candidatsCycle = existing.get();
                candidatsCycle.setCandidat(candidat.get());
                candidatsCycle.setCycle(cycle.get());
                candidatsCycle.setAnneeUniversitaire(anneeUniversitaire.get());
                candidatsCycle.setFichierJoint(dto.getFichierJoint());
                candidatsCycle.setCreatedAt(dto.getCreatedAt());
                candidatsCycle.setUpdatedAt(dto.getUpdatedAt());
                candidatsCycle.setDeletedAt(dto.getDeletedAt());
                candidatsCycle = candidatsCyclesRepository.save(candidatsCycle);
                return candidatsCyclesMapper.toDTO(candidatsCycle);
            } else {
                throw new IllegalArgumentException("Candidat, Cycle, or AnneeUniversitaire not found");
            }
        } else {
            throw new IllegalArgumentException("CandidatsCycle not found");
        }
    }

    public CandidatCycleDTO getCandidatsCycle(Long id) {
        Optional<CandidatsCycles> candidatsCycle = candidatsCyclesRepository.findById(id);
        return candidatsCycle.map(candidatsCyclesMapper::toDTO).orElse(null);
    }

    public List<CandidatCycleDTO> getAllCandidatsCycles() {
        return candidatsCyclesRepository.findAll().stream()
                .map(candidatsCyclesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteCandidatsCycle(Long id) {
        candidatsCyclesRepository.deleteById(id);
    }
}
