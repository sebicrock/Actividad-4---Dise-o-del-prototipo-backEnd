package com.bank.bank.imp.impCreateLoan;

import java.util.List;


import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestLoan.DtoRequestCreateLoan;
import com.bank.bank.model.modelDataLoan.ModelDataLoan;
import com.bank.bank.model.modelDataLoan.ModelLoanReference;
import com.bank.bank.repository.repositoryLoans.RepositoryLoans;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpSavingsLoan {

    private final ImpMapRequestsLoan impMapRequestsLoan;
    private final ImpMapRequestLoadReference impMapRequestLoadReference;
    private final RepositoryLoans repositoryLoans;

    public ModelDataLoan savingDataLoan(DtoRequestCreateLoan dtoRequestCreateLoan){ 

        ModelDataLoan dataLoan = impMapRequestsLoan.mapDataLoan(dtoRequestCreateLoan);

        List<ModelLoanReference> loanReference = impMapRequestLoadReference.mapLoanReference(dtoRequestCreateLoan);

        dataLoan.setReferences(loanReference);

        repositoryLoans.save(dataLoan);



        return dataLoan;
    }

}


