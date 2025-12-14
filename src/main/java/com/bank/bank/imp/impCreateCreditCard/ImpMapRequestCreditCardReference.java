package com.bank.bank.imp.impCreateCreditCard;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateCreditCard.DtoRequestCreateCreditCard;
import com.bank.bank.model.modelCreditCard.ModelCreditCardReference;

@Service
public class ImpMapRequestCreditCardReference {

    public ModelCreditCardReference mapCreditCardReference(DtoRequestCreateCreditCard dtoRequest){

        ModelCreditCardReference dataReference = new ModelCreditCardReference();

        dataReference.setName(dtoRequest.getReferenceName());
        dataReference.setPhone(dtoRequest.getReferencePhone());
        dataReference.setRelationship(dtoRequest.getReferenceRelationship());

        return dataReference;


    }

}
