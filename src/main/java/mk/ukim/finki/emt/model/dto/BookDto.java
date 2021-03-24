package mk.ukim.finki.emt.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.model.Author;
import mk.ukim.finki.emt.model.enumerations.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
public class BookDto {
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private Long authorId;
    private Integer availableCopies;

    public BookDto(Long id,String name, Category category, Long authorId, Integer availableCopies) {
        this.id=id;
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}
