package com.example.backend.service;

import com.example.backend.dto.UserDTO;
import com.example.backend.mapper.UserMapper;
import com.example.backend.model.User;
import com.example.backend.model.Etablissement;
import com.example.backend.repository.UserRepository;
import com.example.backend.repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EtablissementRepository etablissementRepository;

    @Autowired
    private UserMapper userMapper;

    // Create a new user
    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        setEtablissement(userDTO, user);

        try {
            return userMapper.toDTO(userRepository.save(user));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }
    }

    // Get a user by ID
    public UserDTO getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toDTO).orElse(null);
    }

    // Get all users
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .toList();
    }

    // Update an existing user
    public UserDTO update(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = userMapper.toEntity(userDTO);
            user.setId(id);
            user.setUpdatedAt(LocalDateTime.now());

            setEtablissement(userDTO, user);

            try {
                return userMapper.toDTO(userRepository.save(user));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error updating user: " + e.getMessage());
            }
        }
        return null;
    }

    // Delete a user
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    // Helper method to set the Etablissement
    private void setEtablissement(UserDTO userDTO, User user) {
        if (userDTO.getEtablissementId() != null) {
            Optional<Etablissement> etablissement = etablissementRepository.findById(userDTO.getEtablissementId());
            if (etablissement.isPresent()) {
                user.setEtablissement(etablissement.get());
            } else {
                throw new IllegalArgumentException("Etablissement with id " + userDTO.getEtablissementId() + " not found");
            }
        } else {
            user.setEtablissement(null);
        }
    }
}
