package com.bank.bank.imp.impCreateLoan;

import org.springframework.stereotype.Service;

import com.bank.bank.model.modelDataLoan.ModelDataLoan;

@Service
public class ImpTotalAmountLoan {

    public double calculateTotalAmountLoan(ModelDataLoan modelDataLoan) {
        double principal = modelDataLoan.getLoanAmount();
        double totalInterest = modelDataLoan.getTotalInterest();

        return principal + totalInterest;
    }


}
