package pl.coderslab.charity.converters;

import pl.coderslab.charity.dtos.UserDTO;
import pl.coderslab.charity.entities.User;

public class UserConverter {

    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setActive(user.getActive());

        return userDTO;
    }

    public static User fromUserDTO(UserDTO userDTO){
        User user = new User();

        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setActive(userDTO.getActive());

        return user;
    }
}
