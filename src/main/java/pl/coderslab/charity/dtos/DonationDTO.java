package pl.coderslab.charity.dtos;

import lombok.Data;


import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.validators.Checkbox;


import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
public class DonationDTO {


    private Long id;
    @NotNull
    @Min(value = 1)
    private Integer quantity;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    @Pattern(regexp = "^[0-9]{2}(?:-[0-9]{3})?$")
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    @NotNull
    private LocalDate pickUpDate;
    @NotNull
    private LocalTime pickUpTime;
    private String pickUpComment;
    @Pattern(regexp = "^^\\+(?:[0-9]●?){6,14}[0-9]$")
    private String phoneNumber;

    @Checkbox
    private List<Category> categories;

    @NotNull
    private Institution institution;

}
