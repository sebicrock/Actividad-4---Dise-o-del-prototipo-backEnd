package com.bank.bank.imp.impCreateScheduledSavings;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoRequestCreateScheduledSavings;

@Service
public class ImpEstimatedInterest {

    public Double estimatedInteres(DtoRequestCreateScheduledSavings dtoRequest){

        Double annualInterest =  dtoRequest.getInterestRate();
        Long termMonths = dtoRequest.getTermMonths();
        Double targetAmount = dtoRequest.getTargetAmount();
        
        Double interest = (targetAmount * (annualInterest / 100) * termMonths) / 12;

        return interest;


    }

}
