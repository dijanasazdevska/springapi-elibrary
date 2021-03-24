package mk.ukim.finki.emt.service;

import mk.ukim.finki.emt.model.Book;
import mk.ukim.finki.emt.model.dto.BookDto;
import mk.ukim.finki.emt.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAllBooks();
    public Optional<Book> updateBook(Long id, BookDto bookDto
    );
    public void deleteById(Long id);
    public Optional<Book> addNewBook(BookDto bookDto);
    public Optional<Book> findById(Long id);
    public List<Category> getAllCategories();
    public Optional<Book> markBook(Long id);

}
