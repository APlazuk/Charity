package pl.coderslab.charity.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.converters.InstitutionConverter;
import pl.coderslab.charity.dtos.InstitutionDTO;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.services.InstitutionService;

import java.util.List;

@Service
@Transactional
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

    @Override
    public void addInstitution(Institution institution) {
            institutionRepository.save(institution);
    }

    @Override
    public Institution getInstitutionById(Long id) {
        return institutionRepository.findInstitutionById(id);
    }

    @Override
    public void editInstitution(InstitutionDTO editedInstitution) {
        Institution institution = institutionRepository.getOne(editedInstitution.getId());
        institution.setName(editedInstitution.getName());
        institution.setDescription(editedInstitution.getDescription());

        institutionRepository.save(institution);
    }

    @Override
    public void deleteInstitutionById(Long id) {
        institutionRepository.deleteInstitutionById(id);
    }
}
