package com.assignment.bookLibrary.dto.book.v2;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Versioned response body containing a list of books")
public class BookListResponse {

    @Schema(description = "List of books")
    private List<BookResponse> data;

    @Schema(description = "API version")
    private String version;

    public BookListResponse(List<BookResponse> data, String version) {
        this.data = data;
        this.version = version;
    }

    public List<BookResponse> getData() {
        return data;
    }

    public String getVersion() {
        return version;
    }
}