package pl.coderslab.charity.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.converters.UserConverter;
import pl.coderslab.charity.dtos.UserDTO;
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
    public void editAdmin(UserDTO editedAdmin) {
        User user = userRepository.getOne(editedAdmin.getId());
        user.setUsername(editedAdmin.getUsername());
        user.setEmail(editedAdmin.getEmail());
        user.setFirstName(editedAdmin.getFirstName());
        user.setLastName(editedAdmin.getLastName());
        user.setPassword(passwordEncoder.encode(editedAdmin.getPassword()));

        userRepository.save(user);
    }

    @Override
    public User getAdminById(Long id) {
        return userRepository.getAdminById(id);
    }

    @Override
    public void deleteAdminById(Long id) {
        userRepository.deleteUserById(id);
    }
}
