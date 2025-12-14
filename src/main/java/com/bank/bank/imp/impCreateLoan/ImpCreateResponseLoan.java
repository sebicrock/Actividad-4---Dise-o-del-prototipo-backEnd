package com.bank.bank.imp.impCreateLoan;



import org.springframework.stereotype.Service;

import com.bank.bank.Service.CreateLoan.ServiceCreateLoan;
import com.bank.bank.dto.dtoResponse.createLoan.DtoResponseCreatLoan;
import com.bank.bank.dto.dtoResquest.dtoRequestLoan.DtoRequestCreateLoan;
import com.bank.bank.model.modelDataLoan.ModelDataLoan;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpCreateResponseLoan implements ServiceCreateLoan {

    private final ImpValidationRequestLoan impValidationRequestLoan;
    private final ImpSavingsLoan impSavingsLoan;

    public DtoResponseCreatLoan responseCreateLoan(DtoRequestCreateLoan dtoRequest){

        impValidationRequestLoan.validateLoanRequest(dtoRequest);


        ModelDataLoan savedLoan = impSavingsLoan.savingDataLoan(dtoRequest);

        DtoResponseCreatLoan response = new DtoResponseCreatLoan();
        response.setMessage("Prestamo creado exitosamente");
        response.setDataLoan(savedLoan);

        return response;



    }

}
