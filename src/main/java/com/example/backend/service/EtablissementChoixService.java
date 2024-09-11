package com.example.backend.service;

import com.example.backend.dto.EtablissementChoixDTO;
import com.example.backend.mapper.EtablissementChoixMapper;
import com.example.backend.model.EtablissementChoix;
import com.example.backend.repository.EtablissementChoixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EtablissementChoixService {

    @Autowired
    private EtablissementChoixRepository etablissementChoixRepository;

    private final EtablissementChoixMapper etablissementChoixMapper = EtablissementChoixMapper.INSTANCE;
    // Nouvelle méthode pour obtenir l'entité directement
    public EtablissementChoix getEtablissementChoixById(Long id) {
        Optional<EtablissementChoix> etablissementChoix = etablissementChoixRepository.findById(id);
        return etablissementChoix.orElse(null);
    }
    public EtablissementChoixDTO create(EtablissementChoixDTO dto) {
        EtablissementChoix etablissementChoix = etablissementChoixMapper.toEntity(dto);
        etablissementChoix.setCreatedAt(LocalDateTime.now());
        etablissementChoix.setUpdatedAt(LocalDateTime.now());
        return etablissementChoixMapper.toDTO(etablissementChoixRepository.save(etablissementChoix));
    }

    public EtablissementChoixDTO getById(Long id) {
        Optional<EtablissementChoix> etablissementChoix = etablissementChoixRepository.findById(id);
        return etablissementChoix.map(etablissementChoixMapper::toDTO).orElse(null);
    }

    public List<EtablissementChoixDTO> getAll() {
        return etablissementChoixRepository.findAll().stream()
                .map(etablissementChoixMapper::toDTO)
                .toList();
    }

    public EtablissementChoixDTO update(Long id, EtablissementChoixDTO dto) {
        if (etablissementChoixRepository.existsById(id)) {
            EtablissementChoix etablissementChoix = etablissementChoixMapper.toEntity(dto);
            etablissementChoix.setId(id);
            etablissementChoix.setUpdatedAt(LocalDateTime.now());
            return etablissementChoixMapper.toDTO(etablissementChoixRepository.save(etablissementChoix));
        }
        return null;
    }

//    public void delete(Long id) {
//        if (etablissementChoixRepository.existsById(id)) {
//            EtablissementChoix etablissementChoix = etablissementChoixRepository.findById(id).orElse(null);
//            if (etablissementChoix != null) {
//                etablissementChoix.setDeletedAt(LocalDateTime.now());
//                etablissementChoixRepository.save(etablissementChoix);
//            }
//        }
//    }
public void delete(Long id) {
    if (etablissementChoixRepository.existsById(id)) {
        etablissementChoixRepository.deleteById(id); // Suppression physique
    }
}
}
