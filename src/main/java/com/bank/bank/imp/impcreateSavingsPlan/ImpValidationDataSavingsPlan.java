package com.bank.bank.imp.impcreateSavingsPlan;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.DtoRequestCreateRecurringSavingsAccount;
import com.bank.bank.model.modelAccount.ModelAccount;
import com.bank.bank.repository.RepositoryAccount;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImpValidationDataSavingsPlan {

    private final RepositoryClient repositoryClient;
    private final RepositoryAccount repositoryAccount;

    public void validateData(DtoRequestCreateRecurringSavingsAccount dtoRequest){


        repositoryClient.findById(dtoRequest.getIdCliente())
        .orElseThrow(()-> new IllegalArgumentException("El id del cuente no se encuentra creado"));


        ModelAccount dataAccount = repositoryAccount.getByAccountNumber(dtoRequest.getSourceAccount());
        if(dataAccount == null){
            throw new IllegalArgumentException("la cuenta no existe");
        }
    }

}
