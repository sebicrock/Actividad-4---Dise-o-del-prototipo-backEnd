package com.bank.bank.Service;

import com.bank.bank.dto.dtoResponse.createScheduledSavings.DtoResponseCreateScheduled;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoRequestCreateScheduledSavings;


public interface ServiceCreateScheduledSavings {

     DtoResponseCreateScheduled createTotal(DtoRequestCreateScheduledSavings dtoRequest);

}
