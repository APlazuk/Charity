package pl.coderslab.charity.services.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.services.InstitutionService;

import java.util.List;

@Service
public class DefaultInstitutionService implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public DefaultInstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> institutionList() {
        List<Institution> institutions = institutionRepository.findAll();

        return institutions;
    }
}
