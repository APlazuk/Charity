package pl.coderslab.charity.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@ToString(callSuper = true)
public class Institution extends BaseEntity {

    @Column(nullable = false)
    private String name;
    private String description;

}
