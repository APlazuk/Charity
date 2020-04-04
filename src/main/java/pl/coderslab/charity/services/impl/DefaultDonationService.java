package pl.coderslab.charity.services.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.DonationService;

@Service
public class DefaultDonationService implements DonationService {

    private final DonationRepository donationRepository;
    private final UserRepository userRepository;

    public DefaultDonationService(DonationRepository donationRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Donation saveDonation(Donation donation) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findOneByUsername(username);
        donation.setUser(user);

        return donationRepository.save(donation);
    }

    @Override
    public Integer sumOfQuantity() {
        return donationRepository.querySumOfQuantity();
    }

    @Override
    public Integer sumOfDonation() {
        return donationRepository.querySumOfDonation();
    }
}
