package com.assignment.bookLibrary.dto.book.v2;

public class BookResponse {

    private Long id;
    private String title;
    private String isbn;
    private int publishedYear;
    private String authorName;
    private boolean available;

    public BookResponse(Long id, String title, String isbn, int publishedYear, String authorName, boolean available) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.authorName = authorName;
        this.available = available;
    }

    //<editor-fold desc="Getters">

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public String getAuthorName() {
        return authorName;
    }

    public boolean isAvailable() {
        return available;
    }

    //</editor-fold">
}