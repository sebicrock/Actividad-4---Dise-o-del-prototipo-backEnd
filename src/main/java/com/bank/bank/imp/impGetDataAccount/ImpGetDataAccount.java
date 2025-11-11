package com.bank.bank.imp.impGetDataAccount;



import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResponse.getDataAccount.DtoResponseGetDataAccount;
import com.bank.bank.model.modelAccount.ModelAccount;
import com.bank.bank.repository.RepositoryAccount;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImpGetDataAccount {

    private final RepositoryAccount repositoryAccount;
    private final ImpGetDataCard impGetDataCard;



    public DtoResponseGetDataAccount dataAccount(Long numberAccount){

        ModelAccount dataAccount = repositoryAccount.getByAccountNumber(numberAccount);

        DtoResponseGetDataAccount dto = new DtoResponseGetDataAccount();
        dto.setAccountNumber(dataAccount.getAccountNumber());
        dto.setCreationData(dataAccount.getCreationData());
        dto.setCurrentAccountBalance(dataAccount.getCurrentAccountBalance());
        dto.setId(dataAccount.getId());
        dto.setState(dataAccount.getState());
        dto.setTypeAccount(dataAccount.getTypeAccount());
        dto.setUserCreate(dataAccount.getUserCreate());
        dto.setLinkendDebitCard(dataAccount.getLinkedDebitCard());
        dto.setCards(List.of(impGetDataCard.getDataCard(dataAccount.getAccountNumber())));


        return dto;

    } 

}
