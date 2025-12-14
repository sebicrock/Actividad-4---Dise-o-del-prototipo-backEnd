package com.bank.bank.imp.impCreateScheduledSavings;

import org.springframework.stereotype.Service;

import com.bank.bank.Service.ServiceCreateScheduledSavings;
import com.bank.bank.dto.dtoResponse.createScheduledSavings.DtoResponseCreateScheduled;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoRequestCreateScheduledSavings;
import com.bank.bank.model.modelScheduledSavings.ModelScheduledSavings;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor
public class ImpCreateTotal implements ServiceCreateScheduledSavings {

    private final ImpValidationRequestCreateScheduledSavings impValidationRequestCreateScheduledSavings;
    private final ImpSavingsScheduledSavings impSavingsScheduledSavings;
    private final ImpCreateResponseScheduledSavings impCreateResponse;

    public DtoResponseCreateScheduled createTotal(DtoRequestCreateScheduledSavings dtoRequest){

        
        impValidationRequestCreateScheduledSavings.ValidationRequestCreateScheduledSavings(dtoRequest);

        ModelScheduledSavings modelScheduledSavings = impSavingsScheduledSavings.savingsScheduledSavings(dtoRequest);

        DtoResponseCreateScheduled response = impCreateResponse.createResponseScheduledSavings(modelScheduledSavings);

        return response;


    }

}
