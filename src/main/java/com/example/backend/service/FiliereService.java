package com.example.backend.service;

import com.example.backend.dto.FiliereDTO;
import com.example.backend.mapper.FiliereMapper;
import com.example.backend.model.Cycle;
import com.example.backend.model.Filiere;
import com.example.backend.repository.CycleRepository;
import com.example.backend.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    @Autowired
    private CycleRepository cycleRepository;

    private final FiliereMapper filiereMapper = FiliereMapper.INSTANCE;

    public FiliereDTO create(FiliereDTO dto) {
        validateCycle(dto.getIdCycle()); // Vérifier l'existence du Cycle

        Filiere filiere = filiereMapper.toEntity(dto);
        filiere.setCreatedAt(LocalDateTime.now());
        filiere.setUpdatedAt(LocalDateTime.now());
        return filiereMapper.toDTO(filiereRepository.save(filiere));
    }

    public FiliereDTO getById(Long id) {
        Optional<Filiere> filiere = filiereRepository.findById(id);
        return filiere.map(filiereMapper::toDTO).orElse(null);
    }

    public List<FiliereDTO> getAll() {
        List<Filiere> filieres = filiereRepository.findAll();
        return filieres.stream()
                .map(filiere -> {
                    try {
                        // Validation du Cycle
                        if (filiere.getCycle() != null) {
                            Optional<Cycle> optionalCycle = cycleRepository.findById(filiere.getCycle().getId());
                            if (optionalCycle.isEmpty()) {
                                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cycle with ID " + filiere.getCycle().getId() + " does not exist.");
                            }
                        }
                        return filiereMapper.toDTO(filiere);
                    } catch (Exception e) {
                        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error mapping Filiere to DTO", e);
                    }
                })
                .toList();
    }



    public FiliereDTO update(Long id, FiliereDTO dto) {
        if (!filiereRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filiere with ID " + id + " does not exist.");
        }

        validateCycle(dto.getIdCycle()); // Vérifier l'existence du Cycle

        Filiere filiere = filiereMapper.toEntity(dto);
        filiere.setId(id);
        filiere.setUpdatedAt(LocalDateTime.now());
        return filiereMapper.toDTO(filiereRepository.save(filiere));
    }

//    public void delete(Long id) {
//        Optional<Filiere> optionalFiliere = filiereRepository.findById(id);
//        if (optionalFiliere.isPresent()) {
//            Filiere filiere = optionalFiliere.get();
//            filiere.setDeletedAt(LocalDateTime.now());
//            filiereRepository.save(filiere);
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filiere with ID " + id + " does not exist.");
//        }
//    }
public void delete(Long id) {
    if (filiereRepository.existsById(id)) {
        filiereRepository.deleteById(id); // Suppression physique
    } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filiere with ID " + id + " does not exist.");
    }
}



    private void validateCycle(Long cycleId) {
        if (cycleId != null && !cycleRepository.existsById(cycleId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cycle with ID " + cycleId + " does not exist.");
        }
    }
}
