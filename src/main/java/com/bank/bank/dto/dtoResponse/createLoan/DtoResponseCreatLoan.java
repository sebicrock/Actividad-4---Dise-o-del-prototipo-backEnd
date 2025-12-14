package com.bank.bank.dto.dtoResponse.createLoan;

import com.bank.bank.model.modelDataLoan.ModelDataLoan;

import lombok.Data;

@Data
public class DtoResponseCreatLoan {

    String message;
    ModelDataLoan dataLoan;

}
