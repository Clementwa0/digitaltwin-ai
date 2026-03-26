package com.twinai.afterlifeai.service;

import com.twinai.afterlifeai.model.User;
import com.twinai.afterlifeai.dto.UserRequestDTO;
import com.twinai.afterlifeai.dto.UserResponseDTO;
import com.twinai.afterlifeai.exception.UserNotFoundException;
import com.twinai.afterlifeai.repository.UserRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User saved = userRepository.save(user);
        return mapToDTO(saved);
    }

    // READ ALL
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // READ ONE
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return mapToDTO(user);
    }

    // UPDATE
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return mapToDTO(userRepository.save(user));
    }

    // DELETE
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }

    private UserResponseDTO mapToDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }
}