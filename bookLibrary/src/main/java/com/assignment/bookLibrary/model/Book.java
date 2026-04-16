package com.assignment.bookLibrary.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    int publishedYear;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {}

    public Book(String title, String isbn, int publishedYear, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.author = author;
    }

    //<editor-fold desc="Getters">

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishedYear() {
        return publishedYear;
    }
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    //</editor-fold>
}
