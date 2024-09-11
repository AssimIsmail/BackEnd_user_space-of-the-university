package com.example.backend.service;

import com.example.backend.dto.ParamsDTO;
import com.example.backend.mapper.ParamsMapper;
import com.example.backend.model.Params;
import com.example.backend.repository.ParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ParamsService {

    @Autowired
    private ParamsRepository paramsRepository;

    @Autowired
    private ParamsMapper paramsMapper;

    public ParamsDTO create(ParamsDTO paramsDTO) {
        Params params = paramsMapper.toEntity(paramsDTO);
        params.setCreatedAt(LocalDateTime.now());
        params.setUpdatedAt(LocalDateTime.now());
        return paramsMapper.toDTO(paramsRepository.save(params));
    }

    public ParamsDTO getById(Long id) {
        Optional<Params> params = paramsRepository.findById(id);
        return params.map(paramsMapper::toDTO).orElse(null);
    }

    public List<ParamsDTO> getAll() {
        return paramsRepository.findAll().stream()
                .map(paramsMapper::toDTO)
                .toList();
    }

    public ParamsDTO update(Long id, ParamsDTO paramsDTO) {
        if (paramsRepository.existsById(id)) {
            Params params = paramsMapper.toEntity(paramsDTO);
            params.setId(id);
            params.setUpdatedAt(LocalDateTime.now());
            return paramsMapper.toDTO(paramsRepository.save(params));
        }
        return null;
    }

//    public void delete(Long id) {
//        if (paramsRepository.existsById(id)) {
//            Params params = paramsRepository.findById(id).orElse(null);
//            if (params != null) {
//                params.setDeletedAt(LocalDateTime.now());
//                paramsRepository.save(params);
//            }
//        }
//    }
public void delete(Long id) {
    if (paramsRepository.existsById(id)) {
        // Effectuer une suppression physique
        paramsRepository.deleteById(id);
    }
}
}
