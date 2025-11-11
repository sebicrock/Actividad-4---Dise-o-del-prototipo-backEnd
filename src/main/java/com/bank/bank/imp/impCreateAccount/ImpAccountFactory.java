package com.bank.bank.imp.impCreateAccount;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.bank.bank.dto.dtoResquest.DtoRequestCreateAccount;
import com.bank.bank.model.modelAccount.ModelAccount;
import com.bank.bank.model.modelAccount.ModelAccountRequest;
import com.bank.bank.model.modelAccount.ModelDebitCard;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.model.modelDataUser.ModelDataUser;
import com.bank.bank.repository.RepositoryDebitCard;
import com.bank.bank.repository.RepositoryModelAccount;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import java.util.*;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ImpAccountFactory {


    private final RepositoryClient repositoryClient;
    private final RepositoryModelAccount repositoryModelAccount;
    private final RepositoryDebitCard repositoryDebitCard;

    public ModelAccountRequest mapAccountReequest(DtoRequestCreateAccount dto){

        ModelDataClient dataClient = repositoryClient.findById(dto.getClienteId())
            .orElseThrow(()-> new IllegalArgumentException("Cliente no encontrado"));


        ModelAccountRequest modelAccountRequest = new ModelAccountRequest();
        modelAccountRequest.setAcceptTerms(dto.getAcceptTerms());
        modelAccountRequest.setEmailNotifications(dto.getEmailNotifications());
        modelAccountRequest.setEstado(dto.getEstado());
        modelAccountRequest.setFechaSolicitud(LocalDate.now());
        modelAccountRequest.setIncludeDebitCard(dto.getIncludeDebitCard());
        modelAccountRequest.setInitialDeposit(((Number) dto.getInitialDeposit()).longValue());
        modelAccountRequest.setSmsNotifications(dto.getSmsNotifications());
        modelAccountRequest.setTypeAccount(dto.getType());
        modelAccountRequest.setEstado(dto.getEstado());
        modelAccountRequest.setClient(dataClient); 

        return modelAccountRequest;


    }

    public ModelAccount mapAccount(ModelAccountRequest modelAccountRequest, DtoRequestCreateAccount dto){

        ModelDataClient dataClient = repositoryClient.findById(dto.getClienteId())
            .orElseThrow(()-> new IllegalArgumentException("cliente no valido"));

        ModelDataUser modelDataUser = dataClient.getUser();

        ModelAccount modelAccount = new ModelAccount();
        modelAccount.setState(true);
        modelAccount.setCurrentAccountBalance(modelAccountRequest.getInitialDeposit());
        modelAccount.setCreationData(LocalDate.now());
        modelAccount.setTypeAccount(modelAccountRequest.getTypeAccount());
        modelAccount.setUserCreate(modelDataUser.getUserName());

        ModelAccount ultimaCuenta = repositoryModelAccount.findTopByOrderByIdDesc();
        Long newAccount = (ultimaCuenta == null) ? 1000L : ultimaCuenta.getAccountNumber() +1;
        modelAccount.setAccountNumber(newAccount);

        return modelAccount;

    } 

    public ModelDebitCard mapDebitCard(ModelAccount dataAccount, DtoRequestCreateAccount dto){

        ModelDebitCard dataCard = repositoryDebitCard.findTopByOrderByIdDesc();
        Long newDataCard = (dataCard == null) ? 3000L : dataCard.getNumberCard()+1;


        ModelDebitCard modelDebitCard = new ModelDebitCard();
        modelDebitCard.setNumberCard(newDataCard);
        modelDebitCard.setLinkenAccount(dataAccount.getAccountNumber());
        modelDebitCard.setStateCard(true);
        modelDebitCard.setExpirationDate(LocalDate.now().plusYears(1));

        ModelDataClient modelDataClient = repositoryClient.findById(dto.getClienteId()).orElseThrow();
        modelDebitCard.setClient(modelDataClient);
        
        dataAccount.setCards(List.of(modelDebitCard));

        return modelDebitCard;

    }




}


        
