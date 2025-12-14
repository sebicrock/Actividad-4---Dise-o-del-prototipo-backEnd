package com.bank.bank.imp.impCreateCdts;

import org.springframework.stereotype.Service;

@Service
public class ImpGenerateNumberCdts {

    public String generateNumbreCdts(Long clientId) {
        long timestamp = System.currentTimeMillis();
        return "CDT-" + clientId + "-" + timestamp;

    }


}
