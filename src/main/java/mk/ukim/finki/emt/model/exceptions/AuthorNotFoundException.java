package mk.ukim.finki.emt.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException() {
        super("Author not found");

    }
}
