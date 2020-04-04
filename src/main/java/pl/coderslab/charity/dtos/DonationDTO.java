package pl.coderslab.charity.dtos;

import lombok.Data;


import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.validators.Checkbox;


import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
public class DonationDTO {


    private Long id;
    @NotNull//nie wiem dlaczego nie działa mi message.properties pewnie security
    @Min(value = 1, message = "{tomasz.lacina.message}")
    private Integer quantity;
    @NotBlank(message = "Pole nie może być puste")
    private String street;
    @NotBlank(message = "Pole nie może być puste")
    private String city;
    @Pattern(regexp = "^[0-9]{2}(?:-[0-9]{3})?$", message = "Podany kod pocztowy jest nieprawidłowy. Prawidłowy format to: ##-###")
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Proszę wybrać inny termin dostawy. Wymagana przyszła data")
    @NotNull(message = "Pole nie może być puste")
    private LocalDate pickUpDate;
    @NotNull(message = "Pole nie może być puste")
    private LocalTime pickUpTime;
    private String pickUpComment;
    @Pattern(regexp = "^^\\+(?:[0-9]●?){6,14}[0-9]$", message = "Podany numer telefonu jest nieprawidłowy. Prawidłowy format to np.: +48#########")
    private String phoneNumber;

    @Checkbox(message = "Należy zaznaczyć przynajmniej jedno pole")
    private List<Category> categories;

    @NotNull(message = "Należy zaznaczyć jedno pole")
    private Institution institution;

}
