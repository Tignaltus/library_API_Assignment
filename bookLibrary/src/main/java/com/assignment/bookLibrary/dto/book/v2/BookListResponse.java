package com.assignment.bookLibrary.dto.book.v2;

import java.util.List;

public class BookListResponse {

    private List<BookResponse> data;
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