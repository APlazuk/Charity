package pl.coderslab.charity.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
@Data
@ToString(callSuper = true, exclude = "categories")
public class Donation extends BaseEntity {


    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate pickUpDate;
    @Column(nullable = false)
    private LocalTime pickUpTime;
    private String pickUpComment;
    @Column(nullable = false)
    private String phoneNumber;

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private Institution institution;

    @ManyToOne
    private User user;

}
