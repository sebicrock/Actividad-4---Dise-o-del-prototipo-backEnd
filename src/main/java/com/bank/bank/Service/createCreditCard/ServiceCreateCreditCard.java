package com.bank.bank.Service.createCreditCard;

import com.bank.bank.dto.dtoResponse.createCreditCard.DtoResponseCreateCreditCard;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateCreditCard.DtoRequestCreateCreditCard;

public interface ServiceCreateCreditCard {

     DtoResponseCreateCreditCard createCreditCard(DtoRequestCreateCreditCard dtoRequest);

}
