package com.bank.bank.imp.impCreateCreditCard;

import org.springframework.stereotype.Service;

import com.bank.bank.Service.createCreditCard.ServiceCreateCreditCard;
import com.bank.bank.dto.dtoResponse.createCreditCard.DtoResponseCreateCreditCard;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateCreditCard.DtoRequestCreateCreditCard;
import com.bank.bank.model.modelCreditCard.ModelDataCreditCard;
import com.bank.bank.repository.repositoryCreditCard.*;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpCreateResponseCreditCard implements ServiceCreateCreditCard {

    private final ImpValidateRequestCreateCreditCard impValidateRequestCreateCreditCard;
    private final ImpMapRequestCreateCreditCard impMapRequestCreateCreditCard;
    private final RepositoryCreditCard repositoryCreditCard;

    public DtoResponseCreateCreditCard createCreditCard(DtoRequestCreateCreditCard dtoRequest){

        impValidateRequestCreateCreditCard.valudateRequestCreateCreditCard(dtoRequest);

        ModelDataCreditCard dataCreditCard = impMapRequestCreateCreditCard.mapRequesDataCreditCard(dtoRequest);

        repositoryCreditCard.save(dataCreditCard);

        DtoResponseCreateCreditCard response = new DtoResponseCreateCreditCard();
        response.setMensaje("targeta aceptada con exito");
        response.setDataCreditCard(dataCreditCard);

        return response;



    }


}
