package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.service.BookService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("")
    public List<Book> list() {
        return bookService.listAllBook();
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Book>> get(@PathVariable String name) {
        try {
            Date date = new Date();
            Timestamp timestamp2 = new Timestamp(date.getTime());
            System.out.println(timestamp2);
            List<Book> books = bookService.findByName(name);
            return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Book book) {
        bookService.saveBook(book);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Book book, @PathVariable Integer id) {
        try {
            Book existBook = bookService.getBook(id);
            book.setIdbook(id);
            bookService.saveBook(book);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        bookService.deleteBook(id);
    }
}
