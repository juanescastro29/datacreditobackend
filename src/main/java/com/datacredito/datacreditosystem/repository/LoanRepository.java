package com.datacredito.datacreditosystem.repository;

import com.datacredito.datacreditosystem.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
