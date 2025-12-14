package com.bank.bank.imp.impCreateScheduledSavings;

import org.springframework.stereotype.Service;

@Service
public class ImpTotalWithInterest {

    public Double totalWithInterest(Double targetAmount, Double estimatedInterest){

        return targetAmount + estimatedInterest;

    }

}
