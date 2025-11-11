package com.bank.bank.imp.impGetDataAccount;

import org.springframework.stereotype.Service;

import com.bank.bank.Service.GetDataAccountService;
import com.bank.bank.dto.dtoResponse.getDataAccount.DtoResponseGetDataAccount;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpDataAccount implements GetDataAccountService {

    private final ImpGetDataAccount impGetDataAccount;



    @Override
    public DtoResponseGetDataAccount getDataAccount(Long numberAccount){
        

        return impGetDataAccount.dataAccount(numberAccount); 
    }   
    






}
