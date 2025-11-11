package com.bank.bank.dto.dtoResponse.createAccount;

import lombok.Data;

@Data
public class DtoResponseCreateAccount {

    private String mensaje;
    private String name;
    private Long numberAccount;
    private Long numberDebitCard;


}
