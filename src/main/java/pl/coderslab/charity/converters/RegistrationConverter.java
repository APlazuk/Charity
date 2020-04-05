package pl.coderslab.charity.converters;

import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.entities.User;

public class RegistrationConverter {

    public static RegistrationDTO toRegistrationDTO(User user){
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setUsername(user.getUsername());
        registrationDTO.setEmail(user.getEmail());
        registrationDTO.setFirstName(user.getFirstName());
        registrationDTO.setLastName(user.getFirstName());

        return registrationDTO;
    }

    public static User from(RegistrationDTO registrationDTO){
        User user = new User();
        user.setId(registrationDTO.getId());
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setRole(registrationDTO.getRole());
        user.setActive(registrationDTO.getActive());
        user.setPassword(registrationDTO.getPassword());

        return user;
    }
}
