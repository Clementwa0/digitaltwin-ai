package com.twinai.afterlifeai.dto;

/*DTOs are objects specifically used to transfer data between layers (Controller → Service → Controller response) without exposing the entity or database model directly. This is a best practice in backend development. */
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    
    @NotBlank(message = "Name cannot be blank")  /* Ensures that the name field is not null or empty */
    @Size(min=2, max=50, message = "Name must be between 2 and 50 characters")  /* Ensures that the name field is between 2 and 50 characters long */
    private String name;

    @Email(message = "Email should be valid")  /* Ensures that the email field contains a valid email address */
    @NotBlank(message = "Email cannot be blank")  /* Ensures that the email field is not null or empty */
    private String email;

    private String password;

    @NotBlank(message = "Role cannot be blank")
    private String role;
}
