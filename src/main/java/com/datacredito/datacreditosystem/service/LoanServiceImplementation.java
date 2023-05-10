package com.datacredito.datacreditosystem.service;

import com.datacredito.datacreditosystem.model.Loan;
import com.datacredito.datacreditosystem.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImplementation implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void saveLoan(Loan loan) {
        loanRepository.save(loan);
    }

    @Override
    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan getLoan(Integer idLoan) {
        return loanRepository.findById(idLoan).get();
    }

    @Override
    public void deleteLoan(Integer idLoan) {
        loanRepository.deleteById(idLoan);
    }
}
