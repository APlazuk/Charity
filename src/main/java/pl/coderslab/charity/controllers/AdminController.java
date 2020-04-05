package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.converters.InstitutionConverter;
import pl.coderslab.charity.converters.RegistrationConverter;
import pl.coderslab.charity.converters.UserConverter;
import pl.coderslab.charity.dtos.InstitutionDTO;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.dtos.UserDTO;
import pl.coderslab.charity.services.InstitutionService;
import pl.coderslab.charity.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final InstitutionService institutionService;
    private final UserService userService;

    public AdminController(InstitutionService institutionService, UserService userService) {
        this.institutionService = institutionService;
        this.userService = userService;
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

        return "admin/add-institution";
    }

    @PostMapping("/addInstitution")
    public String addInstitution(@Valid @ModelAttribute ("institution") InstitutionDTO institutionDTO, BindingResult result){
        if (result.hasErrors()){
            return "admin/add-institution";
        }

        institutionService.addInstitution(InstitutionConverter.from(institutionDTO));

        return "redirect:/admin/institutions";
    }

    @GetMapping("/editInstitution/{id}")
    public String editInstitution(Model model, @PathVariable Long id) {
        InstitutionDTO editedInstitution = InstitutionConverter.toInstitutionDTO(institutionService.getInstitutionById(id));
        model.addAttribute("editedInstitution",editedInstitution);

        return "admin/edit-institution";
    }

    @PostMapping("/editInstitution/{id}")
    public String editInstitution(@Valid @ModelAttribute ("editedInstitution") InstitutionDTO editedInstitution, BindingResult result){
        if (result.hasErrors()){
            return "admin/edit-institution";
        }

        institutionService.editInstitution(editedInstitution);

        return "redirect:/admin/institutions";
    }

    @RequestMapping("/deleteInstitution/{id}")
    public String deleteInstitution(@PathVariable Long id){

        institutionService.deleteInstitutionById(id);

        return "redirect:/admin/institutions";
    }

    @ModelAttribute("admins")
    public List<UserDTO> adminList(){
        return userService.adminList().stream().map(user -> UserConverter.toUserDTO(user)).collect(Collectors.toList());
    }

    @GetMapping("/admins")
    public String menageAdmins() {
        return "admin/admins";
    }

    @GetMapping("/changeAdminStatus/{id}/{active}")
    public String changeAdminStatus(@PathVariable Long id, @PathVariable Boolean active){
        userService.changeAdminStatus(id, active);
        return "redirect:/admin/admins";
    }

    @GetMapping("/addAdmin")
    public String addAdmin(Model model){
        model.addAttribute("admin", new RegistrationDTO());

        return "admin/add-admin";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(@Valid @ModelAttribute("admin") RegistrationDTO admin, BindingResult result){
        if (result.hasErrors()){
            return "admin/add-admin";
        }
        userService.addAdmin(RegistrationConverter.from(admin));

        return "redirect:/admin/admins";
    }

    @ModelAttribute("users")
    public List<UserDTO> userList() {
        return userService.userList().stream().map(user -> UserConverter.toUserDTO(user)).collect(Collectors.toList());
    }

    @GetMapping("/addUserAsAdmin")
    public String usersAsAdmin(){
        return "admin/add-admin-from-users";
    }

    @GetMapping("/addUserAsAdmin/{id}")
    public String addUserAsAdmin(@PathVariable Long id){
        userService.addUserAsAdmin(id);

        return "redirect:/admin/admins";
    }

    @GetMapping("/editAdmin/{id}")
    public String editAdmin(Model model, @PathVariable Long id) {
        UserDTO editedAdmin = UserConverter.toUserDTO(userService.getAdminById(id));
        model.addAttribute("editedAdmin",editedAdmin);

        return "admin/edit-admin";
    }

    @PostMapping("/editAdmin/{id}")
    public String editAdmin(@Valid @ModelAttribute ("editedAdmin") UserDTO editedAdmin, BindingResult result){
        if (result.hasErrors()){
            return "admin/edit-admin";
        }

        userService.editAdmin(editedAdmin);

        return "redirect:/admin/admins";
    }

    @RequestMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable Long id){

        userService.deleteAdminById(id);

        return "redirect:/admin/admins";
    }

    @GetMapping("/users")
    public String menageUsers() {
        return "admin/users";
    }

    @GetMapping("/changeUserStatus/{id}/{active}")
    public String changeUserStatus(@PathVariable Long id, @PathVariable Boolean active){
        userService.changeUserStatus(id, active);
        return "redirect:/admin/users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("user", new RegistrationDTO());

        return "admin/add-user";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute("user") RegistrationDTO user, BindingResult result){
        if (result.hasErrors()){
            return "admin/add-user";
        }
        userService.addUser(RegistrationConverter.from(user));

        return "redirect:/admin/users";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(Model model, @PathVariable Long id) {
        UserDTO editedUser = UserConverter.toUserDTO(userService.getUserById(id));
        model.addAttribute("editedUser",editedUser);

        return "admin/edit-user";
    }

    @PostMapping("/editUser/{id}")
    public String editUser(@Valid @ModelAttribute ("editedUser") UserDTO editedUser, BindingResult result){
        if (result.hasErrors()){
            return "admin/edit-user";
        }

        userService.editUser(editedUser);

        return "redirect:/admin/users";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){

        userService.deleteUserById(id);

        return "redirect:/admin/users";
    }
}
