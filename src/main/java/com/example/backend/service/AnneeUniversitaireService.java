package com.example.backend.service;

import com.example.backend.dto.AnneeUniversitaireDTO;
import com.example.backend.mapper.AnneeUniversitaireMapper;
import com.example.backend.model.AnneeUniversitaire;
import com.example.backend.repository.AnneeUniversitaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnneeUniversitaireService {

    @Autowired
    private AnneeUniversitaireRepository anneeUniversitaireRepository;

    private final AnneeUniversitaireMapper anneeUniversitaireMapper = AnneeUniversitaireMapper.INSTANCE;
    public Optional<AnneeUniversitaire> findById(Long id) {
        return anneeUniversitaireRepository.findById(id);
    }
    public AnneeUniversitaireDTO create(AnneeUniversitaireDTO dto) {
        AnneeUniversitaire anneeUniversitaire = anneeUniversitaireMapper.toEntity(dto);
        anneeUniversitaire.setCreatedAt(LocalDateTime.now());
        anneeUniversitaire.setUpdatedAt(LocalDateTime.now());
        return anneeUniversitaireMapper.toDTO(anneeUniversitaireRepository.save(anneeUniversitaire));
    }

    public AnneeUniversitaireDTO getById(Long id) {
        Optional<AnneeUniversitaire> anneeUniversitaire = anneeUniversitaireRepository.findById(id);
        return anneeUniversitaire.map(anneeUniversitaireMapper::toDTO).orElse(null);
    }

    public List<AnneeUniversitaireDTO> getAll() {
        return anneeUniversitaireRepository.findAll().stream()
                .map(anneeUniversitaireMapper::toDTO)
                .toList();
    }

    public AnneeUniversitaireDTO update(Long id, AnneeUniversitaireDTO dto) {
        if (anneeUniversitaireRepository.existsById(id)) {
            AnneeUniversitaire anneeUniversitaire = anneeUniversitaireMapper.toEntity(dto);
            anneeUniversitaire.setId(id);
            anneeUniversitaire.setUpdatedAt(LocalDateTime.now());
            return anneeUniversitaireMapper.toDTO(anneeUniversitaireRepository.save(anneeUniversitaire));
        }
        return null;
    }

//    public void delete(Long id) {
//        if (anneeUniversitaireRepository.existsById(id)) {
//            AnneeUniversitaire anneeUniversitaire = anneeUniversitaireRepository.findById(id).orElse(null);
//            if (anneeUniversitaire != null) {
//                anneeUniversitaire.setDeletedAt(LocalDateTime.now());
//                anneeUniversitaireRepository.save(anneeUniversitaire);
//            }
//        }
//    }
public void delete(Long id) {
    if (anneeUniversitaireRepository.existsById(id)) {
        // Suppression physique
        anneeUniversitaireRepository.deleteById(id);
    }
}
}
