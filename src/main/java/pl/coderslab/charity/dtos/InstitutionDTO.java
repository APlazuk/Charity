package pl.coderslab.charity.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class InstitutionDTO {

    private Long id;
    @NotBlank
    private String name;
    private String description;

}
