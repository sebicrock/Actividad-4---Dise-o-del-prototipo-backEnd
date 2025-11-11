package com.bank.bank.Service;

import com.bank.bank.dto.dtoResponse.createAccount.DtoResponseCreateAccount;
import com.bank.bank.dto.dtoResquest.DtoRequestCreateAccount;

public interface CreateAccountService {

    DtoResponseCreateAccount createAccount(DtoRequestCreateAccount dataCreateAccount);
     
}
