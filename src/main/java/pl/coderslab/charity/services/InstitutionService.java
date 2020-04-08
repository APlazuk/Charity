package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.InstitutionDTO;
import pl.coderslab.charity.entities.Institution;

import java.util.List;

public interface InstitutionService {

    List<Institution> institutionList();

    void addInstitution(Institution institution);

    Institution getInstitutionById(Long id);


    void editInstitution(Institution editedInstitution);

    void deleteInstitutionById(Long id);
}
