package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.converters.InstitutionConverter;
import pl.coderslab.charity.dtos.InstitutionDTO;
import pl.coderslab.charity.services.InstitutionService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final InstitutionService institutionService;

    public AdminController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @ModelAttribute("institutions")
    public List<InstitutionDTO> institutionList() {
        return institutionService.institutionList().stream().map(institution -> InstitutionConverter.toInstitutionDTO(institution)).collect(Collectors.toList());
    }

    @GetMapping("")
    public String adminDashboard(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("username", username);

        return "admin/dashboard";
    }

    @GetMapping("/institutions")
    public String menageInstitution(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("username", username);

        return "admin/institutions";
    }
}
