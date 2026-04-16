package com.assignment.bookLibrary.service;

import com.assignment.bookLibrary.dto.loan.*;
import com.assignment.bookLibrary.exception.BookAlreadyLoanedException;
import com.assignment.bookLibrary.exception.BookNotFoundException;
import com.assignment.bookLibrary.model.Book;
import com.assignment.bookLibrary.model.Loan;
import com.assignment.bookLibrary.repository.BookRepository;
import com.assignment.bookLibrary.repository.LoanRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public LoanResponse createLoan(LoanRequest request) {
        Long bookId = request.getBookId();

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book with id: " + bookId + " not found"));

        if (loanRepository.existsByBookIdAndReturnDateIsNull(bookId)) {
            throw new BookAlreadyLoanedException("Book is already on loan");
        }

        Loan loan = new Loan(
                LocalDate.now(),
                null,
                book
        );

        try {
            Loan savedLoan = loanRepository.saveAndFlush(loan);
            return mapToResponse(savedLoan);
        } catch (DataIntegrityViolationException e) {
            throw new BookAlreadyLoanedException("Book is already on loan");
        }
    }

    public List<LoanResponse> getAllLoans() {
        return loanRepository.findByReturnDateIsNull()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private LoanResponse mapToResponse(Loan loan) {
        return new LoanResponse(
                loan.getId(),
                loan.getBook().getId(),
                loan.getBook().getTitle(),
                loan.getLoanDate(),
                loan.getReturnDate()
        );
    }
}