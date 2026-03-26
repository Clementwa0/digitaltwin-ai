package com.twinai.afterlifeai.dto;

/* Why no setters?
    1. Response DTO is immutable → client should not change it.
    2. This is cleaner and safer for APIs.
  Constructor
    1. Assigns values at creation → easy mapping from User entity.
  Getters
    1. Needed for JSON serialization (Spring automatically converts to JSON response). */

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;

    // constructor
    public UserResponseDTO(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}