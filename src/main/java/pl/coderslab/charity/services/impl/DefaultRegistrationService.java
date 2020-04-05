package pl.coderslab.charity.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.converters.RegistrationConverter;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.RegistrationService;

@Service
@Transactional
public class DefaultRegistrationService implements RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DefaultRegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;


        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegistrationDTO registrationDTO) {

        User user = RegistrationConverter.from(registrationDTO);
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setActive(true);
        user.setRole("ROLE_USER");

        userRepository.save(user);
    }
}
