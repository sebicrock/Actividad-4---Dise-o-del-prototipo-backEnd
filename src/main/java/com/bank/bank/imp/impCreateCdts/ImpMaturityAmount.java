package com.bank.bank.imp.impCreateCdts;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateCdt.DtoRequestCreateCdts;

@Service
public class ImpMaturityAmount {

    public Double calculateMaturityAmount(DtoRequestCreateCdts dtoRequestCreateCdts) {
        Double interestRate = dtoRequestCreateCdts.getInterestRate();
        Long cdtAmount = dtoRequestCreateCdts.getCdtAmount();
        Long cdtTerm = dtoRequestCreateCdts.getCdtTerm();

        // Cálculo del monto a la madurez
        Double totalInterest = (cdtAmount * interestRate * cdtTerm) / (100 * 360);
        Double maturityAmount = cdtAmount + totalInterest;

        return maturityAmount;
    }

}
