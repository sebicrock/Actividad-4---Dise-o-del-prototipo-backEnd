package com.bank.bank.imp.impCreateCdts;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateCdt.DtoRequestCreateCdts;

@Service
public class ImpTotalInterestCdts {

    public Double calculateTotalInterest(DtoRequestCreateCdts dtoRequestCreateCdts) {
        Double interestRate = dtoRequestCreateCdts.getInterestRate();
        Long cdtAmount = dtoRequestCreateCdts.getCdtAmount();
        Long cdtTerm = dtoRequestCreateCdts.getCdtTerm();

        // Cálculo del interés total
        Double totalInterest = (cdtAmount * interestRate * cdtTerm) / (100 * 360);

        return totalInterest;
    }


}
