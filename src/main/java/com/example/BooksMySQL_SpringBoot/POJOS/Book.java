package com.example.BooksMySQL_SpringBoot.POJOS;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "book_sequence")
    private long id;
    private String name;
    private String author;
    private Integer length;
    private LocalDate dateOfCreation;
    @Transient
    private Integer writtenYearsAgo;

    public Book() { }

    public Book(String name, String author, Integer length, LocalDate dateOfCreation) {
        this.name = name;
        this.author = author;
        this.length = length;
        this.dateOfCreation = dateOfCreation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Integer getWrittenYearsAgo() {
        return LocalDate.now().getYear() - this.dateOfCreation.getYear();
    }

    public void setWrittenYearsAgo(Integer writtenYearsAgo) {
        this.writtenYearsAgo = writtenYearsAgo;
    }


}
