package mk.ukim.finki.emt.service.impl;

import mk.ukim.finki.emt.model.Book;
import mk.ukim.finki.emt.model.dto.BookDto;
import mk.ukim.finki.emt.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.model.enumerations.Category;
import mk.ukim.finki.emt.repository.AuthorRepository;
import mk.ukim.finki.emt.repository.BookRepository;
import mk.ukim.finki.emt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        book.setName(bookDto.getName());
        book.setAuthor(authorRepository.findById(bookDto.getAuthorId()).orElseThrow(AuthorNotFoundException::new));
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(bookDto.getCategory());
        return Optional.of(bookRepository.save(book));
    }


    @Override
    public void deleteById(Long id) {
         bookRepository.deleteById(id);

    }

    @Override
    public Optional<Book> addNewBook(BookDto bookDto) {
    return   Optional.of( bookRepository.save(new Book(bookDto.getName(),bookDto.getCategory(),authorRepository.findById(bookDto.getAuthorId()).orElseThrow(AuthorNotFoundException::new),bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return bookRepository.findAll().stream().map(book -> book.getCategory()).distinct().collect(Collectors.toList());
    }

    @Override
    public Optional<Book> markBook(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        book.setAvailableCopies(book.getAvailableCopies()-1);
       bookRepository.deleteById(id);

        return book.getAvailableCopies()>0?Optional.of(bookRepository.save(book)):Optional.empty();


}}

