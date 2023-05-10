package com.datacredito.datacreditosystem.service;

import com.datacredito.datacreditosystem.model.Loan;

import java.util.List;

public interface LoanService {

    public void saveLoan(Loan loan);

    public List<Loan> getLoans();

    public Loan getLoan(Integer idLoan);

    public void deleteLoan(Integer idLoan);

}
