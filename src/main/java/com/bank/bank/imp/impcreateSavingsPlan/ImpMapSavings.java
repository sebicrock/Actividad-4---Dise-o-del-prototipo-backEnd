package com.bank.bank.imp.impcreateSavingsPlan;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.DtoRequestCreateRecurringSavingsAccount;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.model.modelSavingsPlan.ModelDataSavingsPlan;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImpMapSavings {

    private final ImpCreateNumberSavingsPlan impCreateNumberSavingsPlan;
    private final RepositoryClient repositoryClient;



    public ModelDataSavingsPlan createSavingsPlan(DtoRequestCreateRecurringSavingsAccount dtoRequest){

        ModelDataClient dataClient = repositoryClient.findById(dtoRequest.getIdCliente()).orElseThrow();

        ModelDataSavingsPlan modelDataSavingsPlan = new ModelDataSavingsPlan();
        modelDataSavingsPlan.setNumberSavingsPlan(impCreateNumberSavingsPlan.createNumberSavingsPlan());
        modelDataSavingsPlan.setTargetAmount(dtoRequest.getTargetAmount());
        modelDataSavingsPlan.setTermMonths(dtoRequest.getTermMonths());
        modelDataSavingsPlan.setSourseAccount(dtoRequest.getSourceAccount());
        modelDataSavingsPlan.setDebitDay(dtoRequest.getDebitDay());
        modelDataSavingsPlan.setAllountExtraDeposits(dtoRequest.getAllowExtraDeposits());
        modelDataSavingsPlan.setAutoRenew(dtoRequest.getAutoRenew());
        modelDataSavingsPlan.setCreatDate(LocalDate.now());
        modelDataSavingsPlan.setNextPaymetDate(LocalDate.now().plusMonths(1));
        modelDataSavingsPlan.setAccountHolder(dataClient.getDocumentNumber());
        modelDataSavingsPlan.setPaidInstallments(0L);
        modelDataSavingsPlan.setRemaningInstallments(dtoRequest.getTermMonths());
        modelDataSavingsPlan.setAccumulatedAmount(0L);
        modelDataSavingsPlan.setRemainingAmount(dtoRequest.getTargetAmount());
        modelDataSavingsPlan.setDataClient(dataClient);
        
        return modelDataSavingsPlan;

    }



}
