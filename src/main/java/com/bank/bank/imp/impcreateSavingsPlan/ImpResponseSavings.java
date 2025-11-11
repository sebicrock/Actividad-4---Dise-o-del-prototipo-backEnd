package com.bank.bank.imp.impcreateSavingsPlan;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResponse.createSavings.DtoResponseSavingsPlan;
import com.bank.bank.model.modelSavingsPlan.ModelDataSavingsPlan;

@Service
public class ImpResponseSavings {



    public DtoResponseSavingsPlan reponseSavingsPlan(ModelDataSavingsPlan dataSavingsPlan){


        DtoResponseSavingsPlan dtoResponse = new DtoResponseSavingsPlan();
        dtoResponse.setMensaje("Ahorro creado con exito");
        dtoResponse.setNumberSavingsPlan(dataSavingsPlan.getNumberSavingsPlan());
        dtoResponse.setSourseAccount(dataSavingsPlan.getSourseAccount());
        dtoResponse.setInstallments(dataSavingsPlan.getTermMonths());

        return dtoResponse;
        




    }


}
