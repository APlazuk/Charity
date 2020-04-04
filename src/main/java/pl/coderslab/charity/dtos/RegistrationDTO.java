package pl.coderslab.charity.dtos;

import lombok.Data;
import lombok.ToString;
import pl.coderslab.charity.validators.UniqueEmail;
import pl.coderslab.charity.validators.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@ToString(exclude = "password")
public class RegistrationDTO {

    @NotBlank
    @Size(min = 3, max = 15)
    @UniqueUsername
    private String username;
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}$")
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    @UniqueEmail
    private String email;
}
