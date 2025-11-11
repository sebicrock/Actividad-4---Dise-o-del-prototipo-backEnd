package com.bank.bank.imp.impCreateAccount;

import org.springframework.stereotype.Service;


import com.bank.bank.dto.dtoResquest.DtoRequestCreateAccount;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImpValidationData {

    public final RepositoryClient repositoryClient;

    public void validatioClient(DtoRequestCreateAccount dto){

        Long id = dto.getClienteId();
        String numberDocument = dto.getDocumentNumber();

        ModelDataClient dataClient = repositoryClient.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Id de cliente no se encuentra en la base de datos"));

        if(!numberDocument.equals(dataClient.getDocumentNumber())){
            throw new IllegalArgumentException("Los numeros de documentos no coinciden");
        }    

    }




}
