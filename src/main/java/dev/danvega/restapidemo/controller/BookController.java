package dev.danvega.restapidemo.controller;

import dev.danvega.restapidemo.model.Book;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books;

    public BookController() {
        books = List.of(
                new Book(1,"Hacking with Spring Boot 2.3: Reactive Edition", "Greg L. Turnquist", "Amazon"),
                new Book(2, "Spring Boot: Up and Running", "Mark Heckler", "OReilly Media, Inc")
                );
    }

    @GetMapping
    public List<Book> findAll() {
        return books;
    }

    @GetMapping("/{id}") // api/books/1
    public Book findById(@PathVariable Integer id) {
       return books.stream().filter(book -> book.getId() == id).findFirst().get();
    }

    @PostMapping
    public void create(@Valid Book book) {
        // before we event get here
    }

    @PutMapping("/{id}")
    public void update(@Valid Book book) {
        // update an existing book
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        // delete by id
    }

    // more endpoints

    public void findBookByAuthor() {

    }

}
