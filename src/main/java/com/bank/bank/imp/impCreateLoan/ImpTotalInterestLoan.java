package com.bank.bank.imp.impCreateLoan;

import org.springframework.stereotype.Service;

import com.bank.bank.model.modelDataLoan.ModelDataLoan;

@Service
public class ImpTotalInterestLoan {


    public double calculateTotalInterest(ModelDataLoan modelDataLoan) {
        double principal = modelDataLoan.getLoanAmount();
        double annualInterestRate = modelDataLoan.getInterestRate() / 100.0;

        // Como loanTerm ya viene en meses, lo usamos directamente
        long numberOfPayments = modelDataLoan.getLoanTerm();

        double monthlyInterestRate = annualInterestRate / 12.0;

        if (monthlyInterestRate == 0) {
            return 0;
        }

        double monthlyPayment = (principal * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        double totalPayment = monthlyPayment * numberOfPayments;
        double totalInterest = totalPayment - principal;

        return totalInterest;
        
    }

}
