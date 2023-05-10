package com.datacredito.datacreditosystem.controller;

import com.datacredito.datacreditosystem.model.Client;
import com.datacredito.datacreditosystem.model.Loan;
import com.datacredito.datacreditosystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/prestamo")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/nuevoPrestamo/{puntaje}")
    public String nuevoPrestamo(@RequestBody Loan loan, @PathVariable Integer puntaje) {
        String respuesta = "";
        if(puntaje >= 591) {
            loanService.saveLoan(loan);
            respuesta = "Prestamo solicitado con exito.";
        }else {
            respuesta = "El cliente no cumple con el puntaje adecuado para su solicitud de prestamo.";
        }
        return respuesta;
    }

    @PutMapping("/pagar")
    public String pagarPrestamo(@RequestBody Map<String, String> datosPagar) {
        Loan loan = null;
        String respuesta = "";
        for (int i = 0; i < loanService.getLoans().size(); i++) {
            if (loanService.getLoans().get(i).getIdLoan() == Integer.parseInt(datosPagar.get("idLoan"))) {
                loan = loanService.getLoans().get(i);
                i = loanService.getLoans().size();
            }
        }

        if (loan != null) {
            if (loan.getValueLoan() > Integer.parseInt(datosPagar.get("value"))) {
                loan.setValueLoan(loan.getValueLoan() - Integer.parseInt(datosPagar.get("value")));
                loanService.saveLoan(loan);
            }else {
                loan.setValueLoan(0);
                loanService.saveLoan(loan);
            }
            respuesta = "Se realizo un pago de  " + datosPagar.get("value") + " al capital del prestamo con id " + loan.getIdLoan() + " y su deuda actual es de " + loan.getValueLoan();
        }else {
            respuesta = "Prestamo con id " + datosPagar.get("idLoan") + " no encontrado.";
        }

        return respuesta;

    }

    @PutMapping("/cancelarPrestamo/{idLoan}")
    public String cancelarPrestamo(@PathVariable Integer idLoan) {
        Loan loan = null;
        String respuesta = "";
        for (int i = 0; i < loanService.getLoans().size(); i++) {
            if (loanService.getLoans().get(i).getIdLoan() == idLoan) {
                loan = loanService.getLoans().get(i);
                i = loanService.getLoans().size();
            }
        }

        if (loan != null) {
            loan.setState("CANCELADO");
            loanService.saveLoan(loan);
            respuesta = "Prestamo con id " + loan.getIdLoan() + " cancelado correctamente.";
        }else {
            respuesta = "Prestamo con id " + idLoan + " no encontrado.";
        }

        return respuesta;

    }

}
