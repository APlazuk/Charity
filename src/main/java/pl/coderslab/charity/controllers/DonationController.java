package pl.coderslab.charity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.converters.DonationConverter;
import pl.coderslab.charity.dtos.DonationDTO;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/app/donation")
public class DonationController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;


    public DonationController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
    }


    @ModelAttribute("institutions")
    public List<Institution> institutionList(){
        return institutionService.institutionList();
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAllCategories();
    }


    @GetMapping("")
    public String donationAction(Model model,Principal principal){
        String username = principal.getName();
        model.addAttribute("username", username);

        model.addAttribute("donations", new DonationDTO());
        return "form";
    }

    @PostMapping("/add")
    public String addDonation(@Valid @ModelAttribute ("donations") DonationDTO donation, BindingResult result){

        if (result.hasErrors()){
            return "form";
        }
        donationService.saveDonation(DonationConverter.from(donation));

        return "form-confirmation";
    }

}
