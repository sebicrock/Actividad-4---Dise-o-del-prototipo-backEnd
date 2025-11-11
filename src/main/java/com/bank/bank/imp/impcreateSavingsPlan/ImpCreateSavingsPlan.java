package com.bank.bank.imp.impcreateSavingsPlan;

import org.springframework.stereotype.Service;

import com.bank.bank.Service.CreateSavingsPlanService;
import com.bank.bank.dto.dtoResponse.createSavings.DtoResponseSavingsPlan;
import com.bank.bank.dto.dtoResquest.DtoRequestCreateRecurringSavingsAccount;
import com.bank.bank.model.modelSavingsPlan.ModelDataSavingsPlan;
import com.bank.bank.model.modelSavingsPlan.ModelRequestSavingsPlan;
import com.bank.bank.repository.repositorySavingsPlang.RepositoryDataSavingsPlan;
import com.bank.bank.repository.repositorySavingsPlang.RepositoryResponsetSavingsPlan;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ImpCreateSavingsPlan implements CreateSavingsPlanService{

    private final ImpValidationDataSavingsPlan impValidationData;
    private final ImpMapRequestSavings impMapRequestSavings;
    private final RepositoryResponsetSavingsPlan repositoryResponset;
    private final ImpMapSavings impMapSavings;
    private final ImpResponseSavings impResponseSavings;
    private final RepositoryDataSavingsPlan repositoryDataSavingsPlan;

    @Override
    public DtoResponseSavingsPlan createSavingsPlan (DtoRequestCreateRecurringSavingsAccount dataRequest){


        impValidationData.validateData(dataRequest);

        ModelRequestSavingsPlan modelRequest = impMapRequestSavings.mapRequestSavingsPlan(dataRequest);
        repositoryResponset.save(modelRequest);

        ModelDataSavingsPlan modelSavingsPlan = impMapSavings.createSavingsPlan(dataRequest);
        repositoryDataSavingsPlan.save(modelSavingsPlan);

        DtoResponseSavingsPlan dtoResponse = impResponseSavings.reponseSavingsPlan(modelSavingsPlan);

        return dtoResponse;









    }

    


}
