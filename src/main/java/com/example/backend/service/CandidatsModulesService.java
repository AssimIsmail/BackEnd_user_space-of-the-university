package com.example.backend.service;

import com.example.backend.dto.CandidatsModulesDTO;
import com.example.backend.mapper.CandidatsModulesMapper;
import com.example.backend.model.CandidatsModules;
import com.example.backend.model.Candidat;
import com.example.backend.model.Module;
import com.example.backend.model.AnneeUniversitaire;
import com.example.backend.repository.CandidatsModulesRepository;
import com.example.backend.repository.CandidatRepository;
import com.example.backend.repository.ModuleRepository;
import com.example.backend.repository.AnneeUniversitaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidatsModulesService {

    @Autowired
    private CandidatsModulesRepository candidatsModulesRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private AnneeUniversitaireRepository anneeUniversitaireRepository;

    @Autowired
    private CandidatsModulesMapper candidatsModulesMapper;

    public CandidatsModulesDTO createCandidatsModules(CandidatsModulesDTO dto) {
        Optional<Candidat> candidat = candidatRepository.findById(dto.getIdCandidat());
        Optional<Module> module = moduleRepository.findById(dto.getIdModule());
        Optional<AnneeUniversitaire> anneeUniversitaire = anneeUniversitaireRepository.findById(dto.getIdAnnee());

        if (candidat.isPresent() && module.isPresent() && anneeUniversitaire.isPresent()) {
            CandidatsModules candidatsModules = candidatsModulesMapper.fromDTO(dto, candidat.get(), module.get(), anneeUniversitaire.get());
            candidatsModules = candidatsModulesRepository.save(candidatsModules);
            return candidatsModulesMapper.toDTO(candidatsModules);
        } else {
            throw new IllegalArgumentException("Candidat, Module, or AnneeUniversitaire not found");
        }
    }

    public CandidatsModulesDTO updateCandidatsModules(Long id, CandidatsModulesDTO dto) {
        Optional<CandidatsModules> existing = candidatsModulesRepository.findById(id);
        if (existing.isPresent()) {
            Optional<Candidat> candidat = candidatRepository.findById(dto.getIdCandidat());
            Optional<Module> module = moduleRepository.findById(dto.getIdModule());
            Optional<AnneeUniversitaire> anneeUniversitaire = anneeUniversitaireRepository.findById(dto.getIdAnnee());

            if (candidat.isPresent() && module.isPresent() && anneeUniversitaire.isPresent()) {
                CandidatsModules candidatsModules = existing.get();
                candidatsModules.setCandidat(candidat.get());
                candidatsModules.setModule(module.get());
                candidatsModules.setAnneeUniversitaire(anneeUniversitaire.get());
                candidatsModules.setMg(dto.getMg());
                candidatsModules.setSession(dto.getSession());
                candidatsModules.setCreatedAt(dto.getCreatedAt());
                candidatsModules.setUpdatedAt(dto.getUpdatedAt());
                candidatsModules.setDeletedAt(dto.getDeletedAt());
                candidatsModules = candidatsModulesRepository.save(candidatsModules);
                return candidatsModulesMapper.toDTO(candidatsModules);
            } else {
                throw new IllegalArgumentException("Candidat, Module, or AnneeUniversitaire not found");
            }
        } else {
            throw new IllegalArgumentException("CandidatsModules not found");
        }
    }

    public CandidatsModulesDTO getCandidatsModules(Long id) {
        Optional<CandidatsModules> candidatsModules = candidatsModulesRepository.findById(id);
        return candidatsModules.map(candidatsModulesMapper::toDTO).orElse(null);
    }

    public List<CandidatsModulesDTO> getAllCandidatsModules() {
        return candidatsModulesRepository.findAll().stream()
                .map(candidatsModulesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteCandidatsModules(Long id) {
        if (candidatsModulesRepository.existsById(id)) {
            candidatsModulesRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("CandidatsModules not found");
        }
    }
}
