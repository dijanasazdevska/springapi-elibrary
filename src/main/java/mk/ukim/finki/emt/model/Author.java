package mk.ukim.finki.emt.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Author {
    @Id
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;
}
