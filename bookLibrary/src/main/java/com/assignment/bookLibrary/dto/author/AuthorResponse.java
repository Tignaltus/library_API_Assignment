package com.assignment.bookLibrary.dto.author;

public class AuthorResponse {

    private Long id;
    private String name;
    private int bookCount;

    public AuthorResponse(Long id, String name, int bookCount) {
        this.id = id;
        this.name = name;
        this.bookCount = bookCount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBookCount() {
        return bookCount;
    }
}