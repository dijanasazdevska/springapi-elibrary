package mk.ukim.finki.emt.service.impl;

import mk.ukim.finki.emt.model.Author;
import mk.ukim.finki.emt.repository.AuthorRepository;
import mk.ukim.finki.emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
