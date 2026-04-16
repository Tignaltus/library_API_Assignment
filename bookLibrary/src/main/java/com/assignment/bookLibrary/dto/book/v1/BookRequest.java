package com.assignment.bookLibrary.dto.book.v1;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookRequest {

    @NotBlank(message = "Title must not be blank")
    private String title;

    private String isbn;
    private int publishedYear;

    @NotNull(message = "Author id must be provided")
    private Long authorId;

    public BookRequest() {}

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}