package com.example.BooksMySQL_SpringBoot.Controllers;

import com.example.BooksMySQL_SpringBoot.POJOS.Book;
import com.example.BooksMySQL_SpringBoot.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void addNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBook(@PathVariable("bookId") long id) {
        bookService.deleteBook(id);
    }

    @PutMapping(path = "{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateBook(@PathVariable("bookId") long id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String author,
                           @RequestParam(required = false) Integer length,
                           @RequestParam(required = false) LocalDate dateOfCreation) {

        bookService.updateBook(id, name, author, length, dateOfCreation);
    }
}
