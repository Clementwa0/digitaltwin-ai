package com.twinai.afterlifeai.dto;

import lombok.*;
/* Why no setters?
    1. Response DTO is immutable → client should not change it.
    2. This is cleaner and safer for APIs.
  Constructor
    1. Assigns values at creation → easy mapping from User entity.
  Getters
    1. Needed for JSON serialization (Spring automatically converts to JSON response). */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;

}