package com.bank.bank.imp.impCreateScheduledSavings;



import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoRequestCreateScheduledSavings;
import com.bank.bank.exceptions.ExceptionsCreateScheduledSavings;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpValidationRequestCreateScheduledSavings {

    private final RepositoryClient repositoryClient;

    public void ValidationRequestCreateScheduledSavings(DtoRequestCreateScheduledSavings dtoRequestCreateScheduledSavings){

        ModelDataClient dataClient = repositoryClient.findById(dtoRequestCreateScheduledSavings.getClienteId())
            .orElseThrow(() -> new  ExceptionsCreateScheduledSavings("el id del clinete no exite valide de nuevo"));

            if(!dataClient.getDocumentNumber().equals(dtoRequestCreateScheduledSavings.getDocumentNumber())){
                throw new ExceptionsCreateScheduledSavings("el numero de documento no coincide con el id del cliente");
            }




    }

}
