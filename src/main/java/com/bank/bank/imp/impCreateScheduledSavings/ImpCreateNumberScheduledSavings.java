package com.bank.bank.imp.impCreateScheduledSavings;

import org.springframework.stereotype.Service;

@Service
public class ImpCreateNumberScheduledSavings {

    public String createNumberScheduledSavings(){
        String numberScheduledSavings = "SS-"+System.currentTimeMillis();
        return numberScheduledSavings;
    }

}
