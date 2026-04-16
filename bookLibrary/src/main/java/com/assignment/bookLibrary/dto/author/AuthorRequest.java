package com.assignment.bookLibrary.dto.author;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Request body for creating an author")
public class AuthorRequest {

    @Schema(description = "Name of the author")
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