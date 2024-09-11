package com.example.backend.service;

import com.example.backend.dto.CandidatDTO;
import com.example.backend.mapper.CandidatMapper;
import com.example.backend.model.*;
import com.example.backend.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private PaysService paysService;

    @Autowired
    private ProfessionsService professionsService;

    @Autowired
    private SerieBacService serieBacService;

    @Autowired
    private VilleService villeService;

    @Autowired
    private CandidatMapper candidatMapper;
    public Optional<Candidat> findById(Long id) {
        return candidatRepository.findById(id);
    }
    public CandidatDTO saveCandidat(CandidatDTO candidatDTO) {
        Candidat candidat = candidatMapper.toEntity(candidatDTO);

        // Fetch and set related entities
        if (candidatDTO.getPaysId() != null) {
            Pays pays = paysService.fetchPaysById(candidatDTO.getPaysId());
            if (pays == null) {
                throw new IllegalArgumentException("Invalid paysId: " + candidatDTO.getPaysId());
            }
            candidat.setPays(pays);
        }
        if (candidatDTO.getProfessionId() != null) {
            Professions profession = professionsService.fetchProfessionById(candidatDTO.getProfessionId());
            if (profession == null) {
                throw new IllegalArgumentException("Invalid professionId: " + candidatDTO.getProfessionId());
            }
            candidat.setProfession(profession);
        }
        if (candidatDTO.getSerieBacId() != null) {
            SerieBac serieBac = serieBacService.fetchSerieBacById(candidatDTO.getSerieBacId());
            if (serieBac == null) {
                throw new IllegalArgumentException("Invalid serieBacId: " + candidatDTO.getSerieBacId());
            }
            candidat.setSerieBac(serieBac);
        }
        if (candidatDTO.getVilleId() != null) {
            Ville ville = villeService.fetchVilleById(candidatDTO.getVilleId());
            if (ville == null) {
                throw new IllegalArgumentException("Invalid villeId: " + candidatDTO.getVilleId());
            }
            candidat.setVille(ville);
        }

        Candidat savedCandidat = candidatRepository.save(candidat);
        return candidatMapper.toDTO(savedCandidat);
    }

    public CandidatDTO updateCandidat(Long id, CandidatDTO candidatDTO) {
        if (!candidatRepository.existsById(id)) {
            throw new IllegalArgumentException("Candidat not found with id: " + id);
        }

        // Set the id in the DTO
        candidatDTO.setId(id);

        return saveCandidat(candidatDTO); // Reuse the saveCandidat method
    }

    public List<CandidatDTO> getAllCandidats() {
        List<Candidat> candidats = candidatRepository.findAll();
        return candidats.stream()
                .map(candidatMapper::toDTO)
                .toList();
    }

    public Optional<CandidatDTO> getCandidatById(Long id) {
        return candidatRepository.findById(id)
                .map(candidatMapper::toDTO);
    }

    public void deleteCandidat(Long id) {
        candidatRepository.deleteById(id);
    }
}
