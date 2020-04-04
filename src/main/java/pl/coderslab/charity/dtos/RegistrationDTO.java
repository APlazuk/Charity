package pl.coderslab.charity.dtos;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@ToString(exclude = "password")
public class RegistrationDTO {

    @NotBlank(message = "Pole nie może być puste")
    @Size(min = 3, max = 15, message = "Nazwa użytownika musi zawierać co najmniej 3 znaki, ale nie może być dłuższa niż 15 znaków")
    private String username;
    @NotBlank(message = "Pole nie może być puste")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}$", message = "Hasło musi zawierać co najmniej 8 znaków, ale nie może być dłuższe niż 15 znaków. W tym jedną dużą literę alfabetu, jeden znak specjalny oraz przynajmniej jedną cyfrę")
    private String password;
    @NotBlank(message = "Pole nie może być puste")
    private String firstName;
    @NotBlank(message = "Pole nie może być puste")
    private String lastName;
    @NotBlank(message = "Pole nie może być puste")
    @Email(message = "Podano błędny E-mail")
    private String email;
}
