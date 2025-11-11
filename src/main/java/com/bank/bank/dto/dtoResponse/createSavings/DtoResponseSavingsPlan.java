package com.bank.bank.dto.dtoResponse.createSavings;

import lombok.Data;

@Data
public class DtoResponseSavingsPlan {

    String mensaje;
    Long numberSavingsPlan;
    Long installments;
    double sourseAccount;


}
