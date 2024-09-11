package com.example.backend.service;

import com.example.backend.dto.VilleDTO;
import com.example.backend.mapper.VilleMapper;
import com.example.backend.model.Ville;
import com.example.backend.model.Pays;
import com.example.backend.repository.VilleRepository;
import com.example.backend.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VilleService {

    @Autowired
    private VilleRepository villeRepository;

    @Autowired
    private PaysRepository paysRepository;

    @Autowired
    private VilleMapper villeMapper;
    public Ville fetchVilleById(Long id) {
        return villeRepository.findById(id).orElse(null);
    }
    public VilleDTO create(VilleDTO villeDTO) {
        Ville ville = villeMapper.toEntity(villeDTO);

        // Vérifier si le Pays existe et le définir dans Ville
        if (villeDTO.getPaysId() != null) {
            Optional<Pays> pays = paysRepository.findById(villeDTO.getPaysId());
            if (pays.isPresent()) {
                ville.setPays(pays.get());
            } else {
                throw new IllegalArgumentException("Pays avec ID " + villeDTO.getPaysId() + " n'existe pas.");
            }
        }

        ville.setCreatedAt(LocalDateTime.now());
        ville.setUpdatedAt(LocalDateTime.now());
        return villeMapper.toDTO(villeRepository.save(ville));
    }

    public VilleDTO getById(Long id) {
        Optional<Ville> ville = villeRepository.findById(id);
        return ville.map(villeMapper::toDTO).orElse(null);
    }

    public List<VilleDTO> getAll() {
        return villeRepository.findAll().stream()
                .map(villeMapper::toDTO)
                .toList();
    }

    public VilleDTO update(Long id, VilleDTO villeDTO) {
        if (villeRepository.existsById(id)) {
            Ville ville = villeMapper.toEntity(villeDTO);
            ville.setId(id);

            // Vérifier si le Pays existe et le définir dans Ville
            if (villeDTO.getPaysId() != null) {
                Optional<Pays> pays = paysRepository.findById(villeDTO.getPaysId());
                if (pays.isPresent()) {
                    ville.setPays(pays.get());
                } else {
                    throw new IllegalArgumentException("Pays avec ID " + villeDTO.getPaysId() + " n'existe pas.");
                }
            }

            ville.setUpdatedAt(LocalDateTime.now());
            return villeMapper.toDTO(villeRepository.save(ville));
        }
        return null;
    }

//    public void delete(Long id) {
//        if (villeRepository.existsById(id)) {
//            Ville ville = villeRepository.findById(id).orElse(null);
//            if (ville != null) {
//                ville.setDeletedAt(LocalDateTime.now());
//                villeRepository.save(ville);
//            }
//        }
//    }
public void delete(Long id) {
    // Supprimer physiquement de la base de données
    if (villeRepository.existsById(id)) {
        villeRepository.deleteById(id);
    }
}
}
