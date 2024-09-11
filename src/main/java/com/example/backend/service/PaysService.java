package com.example.backend.service;

import com.example.backend.dto.PaysDTO;
import com.example.backend.mapper.PaysMapper;
import com.example.backend.model.Pays;
import com.example.backend.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaysService {

    @Autowired
    private PaysRepository paysRepository;

    @Autowired
    private PaysMapper paysMapper;

    public PaysDTO create(PaysDTO paysDTO) {
        Pays pays = paysMapper.toEntity(paysDTO);
        pays.setCreatedAt(LocalDateTime.now());
        pays.setUpdatedAt(LocalDateTime.now());
        return paysMapper.toDTO(paysRepository.save(pays));
    }
    public Pays fetchPaysById(Long id) {
        return paysRepository.findById(id).orElse(null);
    }
    public PaysDTO getById(Long id) {
        Optional<Pays> pays = paysRepository.findById(id);
        return pays.map(paysMapper::toDTO).orElse(null);
    }

    public List<PaysDTO> getAll() {
        return paysRepository.findByDeletedAtIsNull().stream()
                .map(paysMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PaysDTO update(Long id, PaysDTO paysDTO) {
        if (paysRepository.existsById(id)) {
            Pays pays = paysMapper.toEntity(paysDTO);
            pays.setId(id);
            pays.setUpdatedAt(LocalDateTime.now());
            return paysMapper.toDTO(paysRepository.save(pays));
        }
        return null;
    }

//    public void delete(Long id) {
//        Optional<Pays> paysOptional = paysRepository.findById(id);
//        if (paysOptional.isPresent()) {
//            Pays pays = paysOptional.get();
//            pays.setDeletedAt(LocalDateTime.now());
//            paysRepository.save(pays);
//            System.out.println("Pays with ID " + id + " marked as deleted at " + pays.getDeletedAt());
//        } else {
//            System.out.println("Pays with ID " + id + " not found.");
//        }
//    }
public void delete(Long id) {
    if (paysRepository.existsById(id)) {
        paysRepository.deleteById(id);
    }
}

}
