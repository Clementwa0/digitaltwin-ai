package com.twinai.afterlifeai.dto;

/*DTOs are objects specifically used to transfer data between layers (Controller → Service → Controller response) without exposing the entity or database model directly. This is a best practice in backend development. */
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {
    
    @NotBlank(message = "Name cannot be blank")  /* Ensures that the name field is not null or empty */
    private String name;

    @Email(message = "Email should be valid")  /* Ensures that the email field contains a valid email address */
    private String email;

    /* Gets the name field */
    public String getName() { return name; }
    /* Sets the name field */
    public void setName(String name) { this.name = name; }

    /* Gets the email field */
    public String getEmail() { return email; }
    /* Sets the email field */
    public void setEmail(String email) { this.email = email; }
}
