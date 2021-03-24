package mk.ukim.finki.emt.web.rest;

import mk.ukim.finki.emt.model.enumerations.Category;
import mk.ukim.finki.emt.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("http://localhost:3000")
public class CategoryRestController {


    @GetMapping
    public List<Category> findAll(){
        return Arrays.stream(Category.values()).collect(Collectors.toList());

    }
}
