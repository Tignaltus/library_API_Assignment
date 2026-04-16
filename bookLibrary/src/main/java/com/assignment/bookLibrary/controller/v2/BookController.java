package com.assignment.bookLibrary.controller.v2;

import com.assignment.bookLibrary.dto.book.v2.BookListResponse;
import com.assignment.bookLibrary.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("bookControllerV2")
@RequestMapping("/api/v2/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<BookListResponse> getAllBooksV2() {
        return ResponseEntity.ok(bookService.getAllBooksV2());
    }
}