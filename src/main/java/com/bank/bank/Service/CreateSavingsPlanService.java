package com.bank.bank.Service;

import com.bank.bank.dto.dtoResponse.createSavings.DtoResponseSavingsPlan;
import com.bank.bank.dto.dtoResquest.DtoRequestCreateRecurringSavingsAccount;

public interface CreateSavingsPlanService {

    DtoResponseSavingsPlan createSavingsPlan(DtoRequestCreateRecurringSavingsAccount dataRequest); 

}
