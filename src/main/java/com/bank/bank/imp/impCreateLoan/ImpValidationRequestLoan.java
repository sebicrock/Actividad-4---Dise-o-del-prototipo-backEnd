package com.bank.bank.imp.impCreateLoan;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestLoan.DtoRequestCreateLoan;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpValidationRequestLoan {

    private final RepositoryClient repositoryClient;

    public void validateLoanRequest(DtoRequestCreateLoan dtoRequestCreateLoan) {


        if (!repositoryClient.existsById(dtoRequestCreateLoan.getClienteId())) {
            throw new IllegalArgumentException("El cliente con ID " + dtoRequestCreateLoan.getClienteId() + " no existe.");
        }

        if(!repositoryClient.existsByDocumentNumber(dtoRequestCreateLoan.getDocumentNumber())){
            throw new IllegalArgumentException("El número de documento " + dtoRequestCreateLoan.getDocumentNumber() + " no coincide con ningún cliente registrado.");
        }


    }


}
