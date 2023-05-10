package com.datacredito.datacreditosystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;


public class Client {

    private String idClient;

    private String nameClient;

    private String lastNameClient;

    private int scoreCredit;

    public Client() {

    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public int getScoreCredit() {
        return scoreCredit;
    }

    public void setScoreCredit(int scoreCredit) {
        this.scoreCredit = scoreCredit;
    }

}
