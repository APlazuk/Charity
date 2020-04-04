package pl.coderslab.charity.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data @ToString(callSuper = true)
public class Category extends BaseEntity {

    private String name;

}
