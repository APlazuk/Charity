package pl.coderslab.charity.setup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entities.User;

@Component
public class StarterDataCreator implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;

    public StarterDataCreator(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        createAdmin();
    }

    // TODO user dto zapis do bazy danych
    private void createAdmin() {
        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("Admin");
        user.setEmail("admin@admin.pl");
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setActive(true);
        user.setRole("ROLE_ADMIN");

    }
}
