package com.bank.bank.imp.impCreateLoan;

import org.springframework.stereotype.Service;




@Service
public class ImpGenerateNumberLoan {

    public String generateNumberLoan(Long clientId) {
        long timestamp = System.currentTimeMillis();
        return "LN-" + clientId + "-" + timestamp;
    }


}
