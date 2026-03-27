package com.twinai.afterlifeai.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequestDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}