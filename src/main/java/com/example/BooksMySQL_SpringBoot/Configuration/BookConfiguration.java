package com.example.BooksMySQL_SpringBoot.Configuration;

import com.example.BooksMySQL_SpringBoot.POJOS.Book;
import com.example.BooksMySQL_SpringBoot.Repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BookConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
            Book book1 = new Book("Harry Potter", "Rowling", 350, LocalDate.of(2001, 4, 7));
            Book book2 = new Book("Nature", "Bing", 170, LocalDate.of(517, 2, 5));

            bookRepository.saveAll(List.of(book1, book2));
        };
    }
}
