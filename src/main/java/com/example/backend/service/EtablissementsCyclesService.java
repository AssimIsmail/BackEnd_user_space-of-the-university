package com.example.backend.service;

import com.example.backend.dto.EtablissementsCyclesDTO;
import com.example.backend.mapper.EtablissementsCyclesMapper;
import com.example.backend.model.AnneeUniversitaire;
import com.example.backend.model.Cycle;
import com.example.backend.model.EtablissementChoix;
import com.example.backend.model.EtablissementsCycles;
import com.example.backend.repository.AnneeUniversitaireRepository;
import com.example.backend.repository.CycleRepository;
import com.example.backend.repository.EtablissementChoixRepository;
import com.example.backend.repository.EtablissementsCyclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtablissementsCyclesService {

    @Autowired
    private EtablissementsCyclesRepository etablissementsCyclesRepository;

    @Autowired
    private EtablissementChoixRepository etablissementChoixRepository;

    @Autowired
    private CycleRepository cycleRepository;

    @Autowired
    private AnneeUniversitaireRepository anneeUniversitaireRepository;

    @Autowired
    private EtablissementsCyclesMapper etablissementsCyclesMapper;

    public EtablissementsCyclesDTO createEtablissementsCycles(EtablissementsCyclesDTO dto) {
        Optional<EtablissementChoix> etablissementChoix = etablissementChoixRepository.findById(dto.getIdEtablissementChoix());
        Optional<Cycle> cycle = cycleRepository.findById(dto.getIdCycle());
        Optional<AnneeUniversitaire> anneeUniversitaire = anneeUniversitaireRepository.findById(dto.getIdAnnee());

        if (etablissementChoix.isPresent() && cycle.isPresent() && anneeUniversitaire.isPresent()) {
            EtablissementsCycles etablissementsCycles = etablissementsCyclesMapper.fromDTO(dto, etablissementChoix.get(), cycle.get(), anneeUniversitaire.get());
            etablissementsCycles = etablissementsCyclesRepository.save(etablissementsCycles);
            return etablissementsCyclesMapper.toDTO(etablissementsCycles);
        } else {
            throw new IllegalArgumentException("EtablissementChoix, Cycle or AnneeUniversitaire not found");
        }
    }

    public EtablissementsCyclesDTO updateEtablissementsCycles(Long id, EtablissementsCyclesDTO dto) {
        Optional<EtablissementsCycles> existing = etablissementsCyclesRepository.findById(id);
        if (existing.isPresent()) {
            Optional<EtablissementChoix> etablissementChoix = etablissementChoixRepository.findById(dto.getIdEtablissementChoix());
            Optional<Cycle> cycle = cycleRepository.findById(dto.getIdCycle());
            Optional<AnneeUniversitaire> anneeUniversitaire = anneeUniversitaireRepository.findById(dto.getIdAnnee());

            if (etablissementChoix.isPresent() && cycle.isPresent() && anneeUniversitaire.isPresent()) {
                EtablissementsCycles etablissementsCycles = existing.get();
                etablissementsCycles.setEtablissementChoix(etablissementChoix.get());
                etablissementsCycles.setCycle(cycle.get());
                etablissementsCycles.setAnneeUniversitaire(anneeUniversitaire.get());
                etablissementsCycles.setNbrChoix(dto.getNbrChoix());
                etablissementsCycles.setCreatedAt(dto.getCreatedAt());
                etablissementsCycles.setUpdatedAt(dto.getUpdatedAt());
                etablissementsCycles.setDeletedAt(dto.getDeletedAt());
                etablissementsCycles = etablissementsCyclesRepository.save(etablissementsCycles);
                return etablissementsCyclesMapper.toDTO(etablissementsCycles);
            } else {
                throw new IllegalArgumentException("EtablissementChoix, Cycle or AnneeUniversitaire not found");
            }
        } else {
            throw new IllegalArgumentException("EtablissementsCycles not found");
        }
    }

    public EtablissementsCyclesDTO getEtablissementsCycles(Long id) {
        Optional<EtablissementsCycles> etablissementsCycles = etablissementsCyclesRepository.findById(id);
        return etablissementsCycles.map(etablissementsCyclesMapper::toDTO).orElse(null);
    }

    public List<EtablissementsCyclesDTO> getAllEtablissementsCycles() {
        return etablissementsCyclesRepository.findAll().stream()
                .map(etablissementsCyclesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteEtablissementsCycles(Long id) {
        etablissementsCyclesRepository.deleteById(id);
    }
}
