package dev.danvega.restapidemo.controller;

import dev.danvega.restapidemo.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.addAll(Arrays.asList(
            new Book(1,"Hacking with Spring Boot 2.3: Reactive Edition", "Greg L. Turnquist", "Amazon"),
            new Book(2, "Spring Boot: Up and Running", "Mark Heckler", "OReilly Media, Inc")
        ));
    }

    @GetMapping
    public List<Book> findAll() {
        return books;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id) {
       return books.stream().filter(book -> book.getId() == id).findFirst().get();
    }

    @PostMapping
    public void create(Book book) {

    }

    @PutMapping("/{id}")
    public void update(Book book) {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

    }

    public void findBookByAuthor() {

    }

}
