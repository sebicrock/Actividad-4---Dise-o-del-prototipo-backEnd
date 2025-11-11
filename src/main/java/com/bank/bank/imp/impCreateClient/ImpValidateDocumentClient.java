package com.bank.bank.imp.impCreateClient;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestClient.DtoRequestClient;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpValidateDocumentClient {

    private final RepositoryClient repositoryClient;


    public void validateDocumentClient (DtoRequestClient dtoRequest){

        boolean existsClient = repositoryClient.existsByDocumentNumber(dtoRequest.getDocumentNumber());
        if(existsClient == true){
            throw new IllegalArgumentException("El numero de documento ya esta creado");
        }

    }

}
