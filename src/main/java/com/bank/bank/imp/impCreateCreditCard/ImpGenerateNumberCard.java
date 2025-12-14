package com.bank.bank.imp.impCreateCreditCard;

import org.springframework.stereotype.Service;

@Service
public class ImpGenerateNumberCard {


    public String generateNumberCreditCard(Long clientId){
        long timestamp = System.currentTimeMillis();
        return "CC-" + clientId + "-" + timestamp;
    }

}
