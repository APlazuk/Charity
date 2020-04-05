package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.converters.InstitutionConverter;
import pl.coderslab.charity.dtos.InstitutionDTO;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;
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

    @ModelAttribute("username")
    public String userName(Principal principal){
        return principal.getName();
    }

    @GetMapping("")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/institutions")
    public String menageInstitution() {
        return "admin/institutions";
    }

    @GetMapping("/addInstitution")
    public String addInstitution(Model model) {
        model.addAttribute("institution", new InstitutionDTO());

        return "admin/addInstitution";
    }

    @PostMapping("/addInstitution")
    public String addInstitution(@Valid @ModelAttribute ("institution") InstitutionDTO institutionDTO, BindingResult result){
        if (result.hasErrors()){
            return "admin/addInstitution";
        }

        institutionService.addInstitution(InstitutionConverter.from(institutionDTO));

        return "redirect:/admin/institutions";
    }

    @GetMapping("/editInstitution/{id}")
    public String editInstitution(Model model, @PathVariable Long id) {
        InstitutionDTO editedInstitution = InstitutionConverter.toInstitutionDTO(institutionService.getInstitutionById(id));
        model.addAttribute("editedInstitution",editedInstitution);

        return "admin/editInstitution";
    }

    @PostMapping("/editInstitution/{id}")
    public String editInstitution(@Valid @ModelAttribute ("editedInstitution") InstitutionDTO editedInstitution, BindingResult result){
        if (result.hasErrors()){
            return "admin/editInstitution";
        }

        institutionService.editInstitution(editedInstitution);

        return "redirect:/admin/institutions";
    }

    @RequestMapping("/deleteInstitution/{id}")
    public String deleteInstitution(@PathVariable Long id){

        institutionService.deleteInstitutionById(id);

        return "redirect:/admin/institutions";
    }
}
