package com.bank.bank.dto.dtoResponse.createCreditCard;

import com.bank.bank.model.modelCreditCard.ModelDataCreditCard;

import lombok.Data;

@Data
public class DtoResponseCreateCreditCard {

    String mensaje;
    ModelDataCreditCard dataCreditCard;

}
