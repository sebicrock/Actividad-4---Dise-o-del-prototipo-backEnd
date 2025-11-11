package com.bank.bank.dto.dtoResponse.getDataAccount;

import java.time.LocalDate;
import java.util.*;


import lombok.Data;

@Data
public class DtoResponseGetDataAccount {

    long id;
    Long accountNumber;
    Boolean state;
    double CurrentAccountBalance;
    LocalDate creationData;
    Long linkendDebitCard;
    String typeAccount;
    String userCreate;
    List<DtoResponseDataCard> cards;


}
