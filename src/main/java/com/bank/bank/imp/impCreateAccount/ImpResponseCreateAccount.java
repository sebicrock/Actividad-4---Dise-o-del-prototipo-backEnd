package com.bank.bank.imp.impCreateAccount;

import org.springframework.stereotype.Component;

import com.bank.bank.dto.dtoResponse.createAccount.DtoResponseCreateAccount;
import com.bank.bank.dto.dtoResquest.DtoRequestCreateAccount;
import com.bank.bank.model.modelAccount.ModelAccount;
import com.bank.bank.model.modelAccount.ModelDebitCard;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ImpResponseCreateAccount {

    private final RepositoryClient repositoryClient;

    public DtoResponseCreateAccount createResponse(DtoRequestCreateAccount dto, ModelAccount dataAccount, ModelDebitCard dataCard){

        ModelDataClient dataClient = repositoryClient.findById(dto.getClienteId())
            .orElseThrow(()-> new IllegalArgumentException("Cliente no encontrado para la respuesta"));

        DtoResponseCreateAccount dtoResponseCreateAccount = new DtoResponseCreateAccount();
        dtoResponseCreateAccount.setMensaje("Cuenta creada con exito");
        dtoResponseCreateAccount.setName(dataClient.getFullNames()+" "+dataClient.getFullSurNames());
        dtoResponseCreateAccount.setNumberAccount(dataAccount.getAccountNumber());
        dtoResponseCreateAccount.setNumberDebitCard(dataCard.getNumberCard());
        
        return dtoResponseCreateAccount;

    }


}
