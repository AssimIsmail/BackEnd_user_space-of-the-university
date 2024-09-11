package com.example.backend.service;

import com.example.backend.dto.EtablissementDTO;
import com.example.backend.mapper.EtablissementMapper;
import com.example.backend.model.Etablissement;
import com.example.backend.model.Universite;
import com.example.backend.repository.EtablissementRepository;
import com.example.backend.repository.UniversiteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtablissementService {

    @Autowired
    private EtablissementRepository etablissementRepository;

    @Autowired
    private UniversiteRepository universiteRepository;

    @Autowired
    private EtablissementMapper etablissementMapper;

    // Récupérer tous les établissements
    public List<EtablissementDTO> getAllEtablissements() {
        List<Etablissement> etablissements = etablissementRepository.findAll();
        return etablissements.stream()
                .map(etablissementMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Récupérer un établissement par ID
    public EtablissementDTO getEtablissementById(Long id) {
        Optional<Etablissement> etablissement = etablissementRepository.findById(id);
        return etablissement.map(etablissementMapper::toDTO).orElse(null);
    }

    // Créer un nouvel établissement
    @Transactional
    public EtablissementDTO createEtablissement(EtablissementDTO etablissementDTO) {
        if (etablissementDTO == null) {
            throw new IllegalArgumentException("EtablissementDTO must not be null");
        }

        Long universiteId = etablissementDTO.getUniversiteId();
        if (universiteId == null) {
            throw new IllegalArgumentException("UniversiteId must not be null");
        }

        Universite universite = universiteRepository.findById(universiteId)
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));

        Etablissement etablissement = etablissementMapper.toEntity(etablissementDTO);
        etablissement.setUniversite(universite);

        Etablissement savedEtablissement = etablissementRepository.save(etablissement);
        return etablissementMapper.toDTO(savedEtablissement);
    }

    // Mettre à jour un établissement existant
    @Transactional
    public EtablissementDTO updateEtablissement(Long id, EtablissementDTO etablissementDTO) {
        if (!etablissementRepository.existsById(id)) {
            return null; // L'établissement n'existe pas
        }

        Universite universite = universiteRepository.findById(etablissementDTO.getUniversiteId())
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));

        Etablissement etablissement = etablissementMapper.toEntity(etablissementDTO);
        etablissement.setId(id);
        etablissement.setUniversite(universite);

        Etablissement updatedEtablissement = etablissementRepository.save(etablissement);
        return etablissementMapper.toDTO(updatedEtablissement);
    }

    // Supprimer un établissement
    @Transactional
    public boolean deleteEtablissement(Long id) {
        if (!etablissementRepository.existsById(id)) {
            return false; // L'établissement n'existe pas
        }
        etablissementRepository.deleteById(id);
        return true;
    }
}
