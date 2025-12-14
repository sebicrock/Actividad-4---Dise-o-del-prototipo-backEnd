package com.bank.bank.Service.CreateLoan;

import com.bank.bank.dto.dtoResponse.createLoan.DtoResponseCreatLoan;
import com.bank.bank.dto.dtoResquest.dtoRequestLoan.DtoRequestCreateLoan;

public interface ServiceCreateLoan {

     DtoResponseCreatLoan responseCreateLoan(DtoRequestCreateLoan dtoRequest);

}
