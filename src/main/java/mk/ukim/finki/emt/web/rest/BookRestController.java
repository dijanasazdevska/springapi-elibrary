package mk.ukim.finki.emt.web.rest;

import mk.ukim.finki.emt.model.Book;
import mk.ukim.finki.emt.model.dto.BookDto;
import mk.ukim.finki.emt.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<Book> getBooks(){

        return bookService.getAllBooks();
    }
    @PostMapping("/edit/{id}")
    private ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.updateBook(id,bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());


    }
    @PostMapping("/add")
    private ResponseEntity<Book> saveBook(@RequestBody BookDto bookDto){
        return this.bookService.addNewBook(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteById(@PathVariable Long id){
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.badRequest().build();
        this.bookService.deleteById(id);
        return ResponseEntity.ok().build();


    }
    @PostMapping("/mark/{id}")
    private ResponseEntity<Book> markBook(@PathVariable Long id){
        return bookService.markBook(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }
}
