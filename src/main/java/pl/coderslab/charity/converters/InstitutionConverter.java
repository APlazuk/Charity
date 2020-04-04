package pl.coderslab.charity.converters;

import pl.coderslab.charity.dtos.InstitutionDTO;
import pl.coderslab.charity.entities.Institution;

public class InstitutionConverter {

    public static InstitutionDTO toInstitutionDTO (Institution institution){
        InstitutionDTO institutionDTO = new InstitutionDTO();

        institutionDTO.setId(institution.getId());
        institutionDTO.setName(institution.getName());
        institutionDTO.setDescription(institution.getDescription());

        return institutionDTO;
    }
}
