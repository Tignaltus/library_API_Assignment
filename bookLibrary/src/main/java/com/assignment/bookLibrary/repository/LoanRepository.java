package com.assignment.bookLibrary.repository;

import com.assignment.bookLibrary.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    boolean existsByBookIdAndReturnDateIsNull(Long bookId);
    List<Loan> findByReturnDateIsNull();
}