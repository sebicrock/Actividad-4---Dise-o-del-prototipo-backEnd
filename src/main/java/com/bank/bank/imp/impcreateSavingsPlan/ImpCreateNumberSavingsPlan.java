package com.bank.bank.imp.impcreateSavingsPlan;

import org.springframework.stereotype.Service;

import com.bank.bank.model.modelSavingsPlan.ModelDataSavingsPlan;
import com.bank.bank.repository.repositorySavingsPlang.RepositoryDataSavingsPlan;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpCreateNumberSavingsPlan {


    private final  RepositoryDataSavingsPlan repositoryDataSavingsPlan;

    public Long  createNumberSavingsPlan(){

        ModelDataSavingsPlan  dataSavings = repositoryDataSavingsPlan.findTopByOrderByIdDesc();
        Long newNumberSavingsPlan = 0L;

        if(dataSavings == null){
            newNumberSavingsPlan = 8000L;
        }else{
            Long lastNumber = dataSavings.getNumberSavingsPlan();
            newNumberSavingsPlan = (lastNumber != null) ? lastNumber+1 : 8000L;
        }

        return newNumberSavingsPlan;

    }

}
