package pl.coderslab.charity.converters;

import pl.coderslab.charity.dtos.DonationDTO;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Donation;

import java.util.stream.Collectors;


public class DonationConverter {

    public static DonationDTO toDonationDTO(Donation donation){
        DonationDTO dto = new DonationDTO();

        dto.setId(donation.getId());
        dto.setCity(donation.getCity());
        dto.setPhoneNumber(donation.getPhoneNumber());
        dto.setQuantity(donation.getQuantity());
        dto.setStreet(donation.getStreet());
        dto.setZipCode(donation.getZipCode());
        dto.setPickUpDate(donation.getPickUpDate());
        dto.setPickUpTime(donation.getPickUpTime());
        dto.setPickUpComment(donation.getPickUpComment());
        dto.setCategories(donation.getCategories());
        dto.setInstitution(donation.getInstitution());

        return dto;
    }

    public static Donation from(DonationDTO donationDTO){
        Donation donation = new Donation();

        donation.setId(donationDTO.getId());
        donation.setCity(donationDTO.getCity());
        donation.setPhoneNumber(donationDTO.getPhoneNumber());
        donation.setQuantity(donationDTO.getQuantity());
        donation.setStreet(donationDTO.getStreet());
        donation.setZipCode(donationDTO.getZipCode());
        donation.setPickUpDate(donationDTO.getPickUpDate());
        donation.setPickUpTime(donationDTO.getPickUpTime());
        donation.setPickUpComment(donationDTO.getPickUpComment());
        donation.setInstitution(donationDTO.getInstitution());

        return donation;
    }
}
