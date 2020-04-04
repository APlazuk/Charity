package pl.coderslab.charity.services;

import pl.coderslab.charity.entities.Donation;

public interface DonationService {

    Donation saveDonation(Donation donation);
    Integer sumOfQuantity();
    Integer sumOfDonation();
}
