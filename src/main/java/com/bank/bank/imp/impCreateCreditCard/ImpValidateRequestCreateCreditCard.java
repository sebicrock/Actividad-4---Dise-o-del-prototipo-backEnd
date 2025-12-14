package com.bank.bank.imp.impCreateCreditCard;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateCreditCard.DtoRequestCreateCreditCard;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpValidateRequestCreateCreditCard {

    private final RepositoryClient repositoryClient;

    public void valudateRequestCreateCreditCard(DtoRequestCreateCreditCard dtoRequest){

         if (!repositoryClient.existsById(dtoRequest.getClienteId())) {
            throw new IllegalArgumentException(
                    "El cliente con ID " + dtoRequest.getClienteId() + " no existe.");
        }

        if (!repositoryClient.existsByDocumentNumber(dtoRequest.getDocumentNumber())) {
            throw new IllegalArgumentException("El número de documento " + dtoRequest.getDocumentNumber()
                    + " no coincide con ningún cliente registrado.");



    }

    }
}