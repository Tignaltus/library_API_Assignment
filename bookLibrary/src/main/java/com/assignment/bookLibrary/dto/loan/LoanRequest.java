package com.assignment.bookLibrary.dto.loan;

import jakarta.validation.constraints.NotNull;

public class LoanRequest {

    @NotNull(message = "Book id must be provided")
    private Long bookId;

    public LoanRequest() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}