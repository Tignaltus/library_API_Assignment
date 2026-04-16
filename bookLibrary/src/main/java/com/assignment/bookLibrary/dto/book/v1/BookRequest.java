package com.assignment.bookLibrary.dto.book.v1;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request body for creating a book")
public class BookRequest {

    @Schema(description = "Title of the book")
    @NotBlank(message = "Title must not be blank")
    private String title;

    @Schema(description = "ISBN number of the book")
    private String isbn;

    @Schema(description = "Year the book was published")
    private int publishedYear;

    @Schema(description = "Id of the author connected to the book")
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