package com.datacredito.datacreditosystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLoan")
    private int idLoan;

    @Column(name = "valueLoan", nullable = false)
    private int valueLoan;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "idClient", nullable = false)
    private String idClient;


    public Loan(){

    }

    public int getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(int idLoan) {
        this.idLoan = idLoan;
    }

    public int getValueLoan() {
        return valueLoan;
    }

    public void setValueLoan(int valueLoan) {
        this.valueLoan = valueLoan;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
}
