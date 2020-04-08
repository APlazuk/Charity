package pl.coderslab.charity.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DefaultUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> adminList() {
        return userRepository.findAllByRole("ROLE_ADMIN");
    }

    @Override
    public List<User> userList() {
        return userRepository.findAllByRole("ROLE_USER");
    }

    @Override
    public void changeAdminStatus(Long id, Boolean active) {
       Optional<User> admin = Optional.ofNullable(userRepository.getAdminByIdAndStatus(id, active));
        if (admin.isPresent()){
            if (admin.get().getActive())
            admin.get().setActive(false);
            else if (!admin.get().getActive()){
                admin.get().setActive(true);
            }
            userRepository.save(admin.get());
        }
    }

    @Override
    public void addAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRole("ROLE_ADMIN");

        userRepository.save(user);
    }

    @Override
    public void addUserAsAdmin(Long id) {
        User user = userRepository.getOne(id);
        user.setRole("ROLE_ADMIN");

        userRepository.save(user);
    }

    @Override
    public void editAdmin(User editedAdmin) {
        User admin = userRepository.getOne(editedAdmin.getId());
        admin.setUsername(editedAdmin.getUsername());
        admin.setEmail(editedAdmin.getEmail());
        admin.setFirstName(editedAdmin.getFirstName());
        admin.setLastName(editedAdmin.getLastName());
        admin.setPassword(passwordEncoder.encode(editedAdmin.getPassword()));

        userRepository.save(admin);
    }


    @Override
    public User getAdminById(Long id) {
        return userRepository.getAdminById(id);
    }

    @Override
    public void deleteAdminById(Long id) {
        userRepository.deleteAdminById(id);
    }

    @Override
    public void changeUserStatus(Long id, Boolean active) {
        Optional<User> user = Optional.ofNullable(userRepository.getUserByIdAndStatus(id, active));
        if (user.isPresent()){
            if (user.get().getActive())
                user.get().setActive(false);
            else if (!user.get().getActive()){
                user.get().setActive(true);
            }
            userRepository.save(user.get());
        }
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRole("ROLE_USER");

        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void editUser(User editedUser) {
        User user = userRepository.getUserById(editedUser.getId());
        user.setUsername(editedUser.getUsername());
        user.setEmail(editedUser.getEmail());
        user.setFirstName(editedUser.getFirstName());
        user.setLastName(editedUser.getLastName());
        user.setPassword(passwordEncoder.encode(editedUser.getPassword()));

        userRepository.save(user);
    }


    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }
}
