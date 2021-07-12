package dev.danvega.restapidemo.dao;

import dev.danvega.restapidemo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookDAO implements BookDAO {

    private List<Book> books = new ArrayList<>();

    public InMemoryBookDAO() {
        loadBooks();
    }

    @Override
    public Optional<Book> findById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public long count() {
        return books.size();
    }

    @Override
    public Book create(Book book) {
        book.setId((int) (count() + 1));
        books.add(book);
        return book;
    }

    @Override
    public Book update(Book book, int id)  throws RuntimeException {
//        Book existing = findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        // show the duplication first
        int index = books.indexOf(findByIdOrElseThrow(id));
        books.set(index,book);
        return book;
    }

    @Override
    public void delete(int id) {
        books.remove(findByIdOrElseThrow(id));
    }

    private Book findByIdOrElseThrow(int id) {
        return findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    private void loadBooks() {
        books.add(new Book(1,"Hacking with Spring Boot 2.3: Reactive Edition", "Greg L. Turnquist", "Amazon"));
        books.add(new Book(2,"Spring Boot: Up and Running", "Mark Heckler", "OReilly Media, Inc"));
        books.add(new Book(3,"97 Things Every Java Programmer Should Know", "Kevlin Henney, Trisha Gee", "OReilly Media, Inc."));
    }


}
