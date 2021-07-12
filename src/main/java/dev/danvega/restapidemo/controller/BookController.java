package dev.danvega.restapidemo.controller;

import dev.danvega.restapidemo.dao.BookDAO;
import dev.danvega.restapidemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookDAO bookDAO;

    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id) {
//        Optional<Book> book = bookDAO.findById(id);
//        if( book.isPresent() ) {
//            return book.get();
//        } else {
//            throw new RuntimeException("Book with id of " + id + " not found.");
//        }

//        return bookDAO.findById(id).orElseThrow(RuntimeException::new);
        return bookDAO.findById(id).orElseThrow(() -> new RuntimeException("Book with id of " + id + " not found."));
    }

    @PostMapping
    public Book create(@Valid @RequestBody Book book) {
        return bookDAO.create(book);
    }

    @PutMapping("/{id}")
    public Book update(@Valid @RequestBody Book book, @PathVariable Integer id) {
        return bookDAO.update(book,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        bookDAO.delete(id);
    }

    @GetMapping("/findby")
    public List<Book> findBookByAuthor(@RequestParam String author) {
        return null;
    }

    public List<Book> findByPublisher(@RequestParam String publisher) {
        return null;
    }

}
