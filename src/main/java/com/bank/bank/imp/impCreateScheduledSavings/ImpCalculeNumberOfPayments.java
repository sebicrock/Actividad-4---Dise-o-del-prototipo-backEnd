package com.bank.bank.imp.impCreateScheduledSavings;


import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoRequestCreateScheduledSavings;


@Service
public class ImpCalculeNumberOfPayments {

    public Long calculeNumberOfPayment(DtoRequestCreateScheduledSavings dtoRequest){


        Long termMonths = dtoRequest.getTermMonths();
        String frequency = dtoRequest.getFrequency();

        Long numberOfPayments = 0L;

        switch (frequency.toUpperCase()) {
            case "SEMANAL":
                numberOfPayments = termMonths * 4;
                break;
            case "QUINCENAL":
                numberOfPayments = termMonths * 2;
                break;
            case "MENSUAL":
                numberOfPayments = termMonths;
                break;
            default:
                throw new IllegalArgumentException("Frecuencia no válida: " + frequency);
        }

        return numberOfPayments;

        





    }

}
