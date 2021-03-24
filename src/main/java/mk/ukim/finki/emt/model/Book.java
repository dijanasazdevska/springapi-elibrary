package mk.ukim.finki.emt.model;

import lombok.Data;
import mk.ukim.finki.emt.model.enumerations.Category;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
private String name;
@Enumerated(value = EnumType.STRING)
private Category category;
@ManyToOne
private Author author;
private Integer availableCopies;

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {

    }
}
