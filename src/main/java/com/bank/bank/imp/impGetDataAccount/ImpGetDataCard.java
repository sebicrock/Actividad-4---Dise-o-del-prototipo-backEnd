package com.bank.bank.imp.impGetDataAccount;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResponse.getDataAccount.DtoResponseDataCard;
import com.bank.bank.model.modelAccount.ModelDebitCard;
import com.bank.bank.repository.RepositoryDebitCard;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpGetDataCard {

    private final RepositoryDebitCard repositoryDebitCard;

    public DtoResponseDataCard getDataCard(Long numberAccount){

        ModelDebitCard dataCard = repositoryDebitCard.findbyNumbeCard(numberAccount);


        DtoResponseDataCard dto = new DtoResponseDataCard();
        dto.setId(dataCard.getId());
        dto.setLinkenAccount(dataCard.getLinkenAccount());
        dto.setStateCard(dataCard.getStateCard());
        dto.setExpirationDate(dataCard.getExpirationDate());
        dto.setTypeCard(dataCard.getTypeCard());

        return dto;



    } 

}
