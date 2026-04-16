package com.assignment.bookLibrary.dto.book.v1;

public class BookResponse {

    private Long id;
    private String title;
    private String isbn;
    private int publishedYear;
    private String authorName;

    public BookResponse(Long id, String title, String isbn, int publishedYear, String authorName) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.authorName = authorName;
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

    //</editor-fold>
}