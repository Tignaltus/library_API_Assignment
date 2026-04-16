package com.assignment.bookLibrary.service;

import com.assignment.bookLibrary.dto.book.v1.BookResponse;
import com.assignment.bookLibrary.dto.book.v2.BookListResponse;
import com.assignment.bookLibrary.dto.book.v1.BookRequest;
import com.assignment.bookLibrary.exception.AuthorNotFoundException;
import com.assignment.bookLibrary.exception.BookNotFoundException;
import com.assignment.bookLibrary.model.Author;
import com.assignment.bookLibrary.model.Book;
import com.assignment.bookLibrary.repository.AuthorRepository;
import com.assignment.bookLibrary.repository.BookRepository;
import com.assignment.bookLibrary.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final LoanRepository loanRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.loanRepository = loanRepository;
    }

    public BookResponse createBook(BookRequest request) {
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException("Author with id: " + request.getAuthorId() + " not found"));

        Book book = new Book(
                request.getTitle(),
                request.getIsbn(),
                request.getPublishedYear(),
                author
        );

        Book savedBook = bookRepository.save(book);
        return mapToResponse(savedBook);
    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));

        return mapToResponse(book);
    }

    public BookListResponse getAllBooksV2() {
        List<com.assignment.bookLibrary.dto.book.v2.BookResponse> books = bookRepository.findAll()
                .stream()
                .map(this::mapToResponseV2)
                .toList();

        return new BookListResponse(books, "v2");
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

    private com.assignment.bookLibrary.dto.book.v2.BookResponse mapToResponseV2(Book book) {
        boolean available = !loanRepository.existsByBookIdAndReturnDateIsNull(book.getId());

        return new com.assignment.bookLibrary.dto.book.v2.BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getPublishedYear(),
                book.getAuthor().getName(),
                available
        );
    }
}