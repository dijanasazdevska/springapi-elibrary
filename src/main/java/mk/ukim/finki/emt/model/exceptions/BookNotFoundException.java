package mk.ukim.finki.emt.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {

        super("Book not found");
    }
}
