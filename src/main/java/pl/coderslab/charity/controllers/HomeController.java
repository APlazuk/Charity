package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.converters.InstitutionConverter;
import pl.coderslab.charity.dtos.InstitutionDTO;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/")
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("")
    public String homeAction(Model model) {

        model.addAttribute("sumOfQuantity", donationService.sumOfQuantity());
        model.addAttribute("sumOfDonation", donationService.sumOfDonation());

        return "index";
    }

    @ModelAttribute("institutions")
    public List<InstitutionDTO> institutionList() {
        return institutionService.institutionList().stream().map(institution -> InstitutionConverter.toInstitutionDTO(institution)).collect(Collectors.toList());
    }


}
