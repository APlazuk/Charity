package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.UserDTO;
import pl.coderslab.charity.entities.User;

import java.util.List;

public interface UserService {

    List<User> adminList();
    List<User> userList();

    void changeAdminStatus(Long id, Boolean active);


    void addAdmin(User user);

    void addUserAsAdmin(Long id);

    void editAdmin(User editedAdmin);

    User getAdminById(Long id);

    void deleteAdminById(Long id);

    void changeUserStatus(Long id, Boolean active);

    void addUser(User user);

    User getUserById(Long id);

    void editUser(User editedUser);

    void deleteUserById(Long id);
}
