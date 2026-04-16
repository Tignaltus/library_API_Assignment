package com.assignment.bookLibrary.controller.v1;

import com.assignment.bookLibrary.dto.author.AuthorRequest;
import com.assignment.bookLibrary.dto.author.AuthorResponse;
import com.assignment.bookLibrary.dto.book.v1.BookResponse;
import com.assignment.bookLibrary.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@Valid @RequestBody AuthorRequest request) {
        AuthorResponse response = authorService.createAuthor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<BookResponse>> getBooksByAuthorId(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getBooksByAuthorId(id));
    }
}