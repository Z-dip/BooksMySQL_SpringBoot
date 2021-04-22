package com.example.BooksMySQL_SpringBoot.Services;

import com.example.BooksMySQL_SpringBoot.POJOS.Book;
import com.example.BooksMySQL_SpringBoot.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findBookByName(book.getName());

        if (optionalBook.isPresent()) throw new IllegalStateException("This book already exists");
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        boolean exists = bookRepository.existsById(id);

        if (!exists) throw new IllegalStateException("Given book id doesn't exist in our database");
        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateBook(long id, String name, String author, Integer length, LocalDate dateOfCreation) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Book with this id doesn't exist"));

        if (name != null && name.length() > 0 && !Objects.equals(book.getName(), name)) {
            book.setName(name);
        }
        if (author != null && author.length() > 0 && !Objects.equals(book.getAuthor(), author)) {
            book.setAuthor(author);
        }
        if (length != null && length > 0 && !Objects.equals(book.getLength(), length)) {
            book.setLength(length);
        }
        if (dateOfCreation != null && !Objects.equals(book.getDateOfCreation(), dateOfCreation)) {
            book.setDateOfCreation(dateOfCreation);
        }
    }
}
