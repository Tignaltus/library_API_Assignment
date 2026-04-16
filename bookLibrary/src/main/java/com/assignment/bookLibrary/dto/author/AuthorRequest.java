package com.assignment.bookLibrary.dto.author;

import jakarta.validation.constraints.NotBlank;

public class AuthorRequest {

    @NotBlank(message = "Author name must not be blank")
    private String name;

    public AuthorRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}