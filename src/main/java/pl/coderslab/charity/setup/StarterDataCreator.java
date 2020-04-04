package pl.coderslab.charity.setup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.repositories.UserRepository;

@Component
public class StarterDataCreator implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public StarterDataCreator(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        createAdmin();
    }

    private void createAdmin() {
        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("Admin");
        user.setEmail("admin@admin.pl");
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setActive(true);
        user.setRole("ROLE_ADMIN");

        if (!userRepository.existsUserByUsername(user.getUsername()) || !userRepository.existsUserByEmail(user.getEmail())){
            userRepository.save(user);
        }
    }
}
