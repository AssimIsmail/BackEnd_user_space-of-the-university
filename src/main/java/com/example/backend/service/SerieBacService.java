package com.example.backend.service;

import com.example.backend.dto.SerieBacDTO;
import com.example.backend.mapper.SerieBacMapper;
import com.example.backend.model.SerieBac;
import com.example.backend.repository.SerieBacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SerieBacService {

    @Autowired
    private SerieBacRepository serieBacRepository;

    @Autowired
    private SerieBacMapper serieBacMapper;
    public SerieBac fetchSerieBacById(Long id) {
        return serieBacRepository.findById(id).orElse(null);
    }
    public SerieBacDTO create(SerieBacDTO serieBacDTO) {
        SerieBac serieBac = serieBacMapper.toEntity(serieBacDTO);
        serieBac.setCreatedAt(LocalDateTime.now());
        serieBac.setUpdatedAt(LocalDateTime.now());
        return serieBacMapper.toDTO(serieBacRepository.save(serieBac));
    }

    public SerieBacDTO getById(Long id) {
        Optional<SerieBac> serieBac = serieBacRepository.findById(id);
        return serieBac.map(serieBacMapper::toDTO).orElse(null);
    }

    public List<SerieBacDTO> getAll() {
        return serieBacRepository.findAll().stream()
                .map(serieBacMapper::toDTO)
                .toList();
    }

    public SerieBacDTO update(Long id, SerieBacDTO serieBacDTO) {
        if (serieBacRepository.existsById(id)) {
            SerieBac serieBac = serieBacMapper.toEntity(serieBacDTO);
            serieBac.setId(id);
            serieBac.setUpdatedAt(LocalDateTime.now());
            return serieBacMapper.toDTO(serieBacRepository.save(serieBac));
        }
        return null;
    }

//    public void delete(Long id) {
//        if (serieBacRepository.existsById(id)) {
//            SerieBac serieBac = serieBacRepository.findById(id).orElse(null);
//            if (serieBac != null) {
//                serieBacRepository.delete(serieBac);
//            }
//        }
//    }
public void delete(Long id) {
    if (serieBacRepository.existsById(id)) {
        SerieBac serieBac = serieBacRepository.findById(id).orElse(null);
        if (serieBac != null) {
            serieBacRepository.delete(serieBac);
        }
    }
}
}
