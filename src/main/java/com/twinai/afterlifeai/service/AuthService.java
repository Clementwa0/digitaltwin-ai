package com.twinai.afterlifeai.service;

import com.twinai.afterlifeai.dto.AuthRequestDTO;
import com.twinai.afterlifeai.dto.AuthResponseDTO;
import com.twinai.afterlifeai.dto.UserRequestDTO;
import com.twinai.afterlifeai.exception.UserNotFoundException;
import com.twinai.afterlifeai.model.User;
import com.twinai.afterlifeai.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService; // We'll implement this to generate JWTs

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // REGISTER
    public AuthResponseDTO register(UserRequestDTO dto) {
        // Check if email already exists
        Optional<User> existing = userRepository.findByEmail(dto.getEmail());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setPassword(passwordEncoder.encode(dto.getPassword())); // hash password

        User saved = userRepository.save(user);

        // Generate JWT token after registration
        String token = jwtService.generateToken(saved);

        return new AuthResponseDTO(token);
    }

    // LOGIN
    public AuthResponseDTO login(AuthRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        // Verify password
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        // Generate JWT token on successful login
        String token = jwtService.generateToken(user);

        return new AuthResponseDTO(token);
    }
}