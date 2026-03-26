package com.twinai.afterlifeai.service;

import com.twinai.afterlifeai.model.User;
import com.twinai.afterlifeai.dto.UserRequestDTO;
import com.twinai.afterlifeai.dto.UserResponseDTO;
import com.twinai.afterlifeai.exception.UserNotFoundException;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private Long idCounter = 4L; // Start after initData

    @PostConstruct
    public void initData() {
        users.add(new User(1L, "Alice", "alice@example.com"));
        users.add(new User(2L, "Bob", "bob@example.com"));
        users.add(new User(3L, "Charlie", "charlie@example.com"));
    }

    // CREATE
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setId(idCounter++);
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        users.add(user);
        return mapToDTO(user);
    }

    // READ ALL
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> result = new ArrayList<>();
        for (User u : users) {
            result.add(mapToDTO(u));
        }
        return result;
    }

    // READ ONE
    public UserResponseDTO getUserById(Long id) {
        User user = findUserById(id);
        return mapToDTO(user);
    }

    // UPDATE
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user = findUserById(id);
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return mapToDTO(user);
    }

    // DELETE
    public void deleteUser(Long id) {
        User user = findUserById(id);
        users.remove(user);
    }

    // Helper: find user or throw exception
    private User findUserById(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    // Helper: map entity → DTO
    private UserResponseDTO mapToDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }
}