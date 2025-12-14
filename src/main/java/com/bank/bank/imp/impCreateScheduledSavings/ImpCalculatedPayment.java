package com.bank.bank.imp.impCreateScheduledSavings;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoRequestCreateScheduledSavings;

@Service
public class ImpCalculatedPayment {

    public Double calculatedPayment(DtoRequestCreateScheduledSavings dtoRequest){
        
        if(dtoRequest.getTargetAmount() == 0){
            return 0.0;
        }

        return dtoRequest.getTargetAmount()/ dtoRequest.getTermMonths();

    }

}
