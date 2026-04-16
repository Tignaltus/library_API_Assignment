package com.assignment.bookLibrary.service;

import com.assignment.bookLibrary.dto.author.AuthorRequest;
import com.assignment.bookLibrary.dto.author.AuthorResponse;
import com.assignment.bookLibrary.dto.book.v1.BookResponse;
import com.assignment.bookLibrary.exception.AuthorNotFoundException;
import com.assignment.bookLibrary.model.Author;
import com.assignment.bookLibrary.model.Book;
import com.assignment.bookLibrary.repository.AuthorRepository;
import com.assignment.bookLibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public AuthorResponse createAuthor(AuthorRequest request) {
        Author author = new Author(request.getName());
        Author savedAuthor = authorRepository.save(author);
        return mapToAuthorResponse(savedAuthor);
    }

    public AuthorResponse getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author with id: " + id + " not found"));

        return mapToAuthorResponse(author);
    }

    public List<BookResponse> getBooksByAuthorId(Long authorId) {
        authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException("Author with id: " + authorId + " not found"));

        return bookRepository.findByAuthorId(authorId)
                .stream()
                .map(this::mapBookToResponse)
                .toList();
    }

    private AuthorResponse mapToAuthorResponse(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getBooks().size()
        );
    }

    private BookResponse mapToResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getPublishedYear(),
                book.getAuthor().getName()
        );
    }

    private BookResponse mapBookToResponse(Book book) {
        return mapToResponse(book);
    }
}