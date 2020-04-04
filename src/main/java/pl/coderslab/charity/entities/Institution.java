package pl.coderslab.charity.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@ToString(callSuper = true)
public class Institution extends BaseEntity {

    private String name;
    private String description;

}
