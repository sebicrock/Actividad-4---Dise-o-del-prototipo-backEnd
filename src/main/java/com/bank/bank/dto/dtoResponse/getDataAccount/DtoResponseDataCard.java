package com.bank.bank.dto.dtoResponse.getDataAccount;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DtoResponseDataCard {

    Long id;
    Long linkenAccount;
    Long NumberCard;
    String typeCard;
    Boolean stateCard;
    LocalDate ExpirationDate;



}
