package com.bank.bank.Service;

import com.bank.bank.dto.dtoResponse.getDataAccount.DtoResponseGetDataAccount;


public interface GetDataAccountService {

    DtoResponseGetDataAccount getDataAccount(Long numberAccount);

}
