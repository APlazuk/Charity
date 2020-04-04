package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.converters.InstitutionConverter;
import pl.coderslab.charity.dtos.InstitutionDTO;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.services.InstitutionService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/")
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionService institutionService, DonationRepository donationRepository) {
        this.institutionService = institutionService;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("")
    public String homeAction(Model model) {

        model.addAttribute("sumOfQuantity", donationRepository.querySumOfQuantity());
        model.addAttribute("sumOfDonation", donationRepository.querySumOfDonation());

        return "index";
    }

    @ModelAttribute("institutions")
    public List<InstitutionDTO> institutionList() {
        return institutionService.institutionList().stream().map(institution -> InstitutionConverter.toInstitutionDTO(institution)).collect(Collectors.toList());
    }


}
