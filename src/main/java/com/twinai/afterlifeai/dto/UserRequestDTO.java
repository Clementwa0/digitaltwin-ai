package com.twinai.afterlifeai.dto;

/*DTOs are objects specifically used to transfer data between layers (Controller → Service → Controller response) without exposing the entity or database model directly. This is a best practice in backend development. */
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    
    @NotBlank(message = "Name cannot be blank")  /* Ensures that the name field is not null or empty */
    private String name;

    @Email(message = "Email should be valid")  /* Ensures that the email field contains a valid email address */
    private String email;

}
