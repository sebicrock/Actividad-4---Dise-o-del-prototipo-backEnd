package com.bank.bank.imp.impcreateSavingsPlan;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.DtoRequestCreateRecurringSavingsAccount;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.model.modelSavingsPlan.ModelRequestSavingsPlan;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ImpMapRequestSavings {

    private final RepositoryClient repositoryClient;

    public ModelRequestSavingsPlan mapRequestSavingsPlan(DtoRequestCreateRecurringSavingsAccount dtoData){

        ModelDataClient dataClient = repositoryClient.findById(dtoData.getIdCliente())
            .orElseThrow(()-> new IllegalArgumentException("El id del cliente no exite"));


        ModelRequestSavingsPlan modelSavingsPlan = new ModelRequestSavingsPlan();
        modelSavingsPlan.setAllowExtraDeposit(dtoData.getAllowExtraDeposits());
        modelSavingsPlan.setAutoRenew(dtoData.getAutoRenew());
        modelSavingsPlan.setCustomGoal(dtoData.getCustomGoal());
        modelSavingsPlan.setDebitDay(dtoData.getDebitDay());
        modelSavingsPlan.setGoalType(dtoData.getGoalType());
        modelSavingsPlan.setNotifications(dtoData.getNotifications());
        modelSavingsPlan.setSourseAccount(dtoData.getSourceAccount());
        modelSavingsPlan.setTargetAmount(dtoData.getTargetAmount());
        modelSavingsPlan.setTermMonths(dtoData.getTermMonths());
        modelSavingsPlan.setCreationDate(LocalDate.now());
        modelSavingsPlan.setSavingsPlanClient(dataClient);

        return modelSavingsPlan;

    }

}
