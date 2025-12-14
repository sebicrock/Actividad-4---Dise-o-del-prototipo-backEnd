package com.bank.bank.imp.impCreateCreditCard;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateCreditCard.DtoRequestCreateCreditCard;
import com.bank.bank.model.modelCreditCard.ModelCreditCardReference;
import com.bank.bank.model.modelCreditCard.ModelDataCreditCard;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpMapRequestCreateCreditCard {

    private final ImpValidateRequestCreateCreditCard impValidateRequestCreateCreditCard;
    private final ImpGenerateNumberCard impGenerateNumberCard;
    private final ImpEstimatedCreditLimit impEstimatedCreditLimit;
    private final ImpMonthlyLoanPayment impMonthlyLoanPayment;
    private final ImpTotalCreditLimitCreditCard impTotalCreditLimitCreditCard;
    private final ImpMapRequestCreditCardReference impMapRequestCreditCardReference;

   public ModelDataCreditCard mapRequesDataCreditCard(DtoRequestCreateCreditCard dtoRequest){

    impValidateRequestCreateCreditCard.valudateRequestCreateCreditCard(dtoRequest);

    ModelDataCreditCard dataCreditCard = new ModelDataCreditCard();

    // numero de tarjeta
    dataCreditCard.setNumbrerCard(impGenerateNumberCard.generateNumberCreditCard(dtoRequest.getClienteId()));

    // tipo tarjeta
    dataCreditCard.setCardType(dtoRequest.getCardType());
    
    // tipo de empleo
    dataCreditCard.setEmploymentType(dtoRequest.getEmploymentType());

    //  indica si tiene tarjetas
    dataCreditCard.setHasCreditCards(dtoRequest.getHasCreditCards());

    // limite de credito de la tarjeta 
    dataCreditCard.setTotalCreditLimit(impTotalCreditLimitCreditCard.totalCreditLimitCreditCard(dtoRequest));

    //indica si tiene creditos activos
    dataCreditCard.setHasLoans(dtoRequest.getHasLoans());

    //pago mensual de creditos activos 
    dataCreditCard.setMonthlyLoanPayment(impMonthlyLoanPayment.monthlyLoanPayment(dtoRequest));

    // banco de referencia 
    dataCreditCard.setBankReference(dtoRequest.getBankReference());

    // diseño de tarjeta 
    dataCreditCard.setCardDesign(dtoRequest.getCardDesign());

    // direccion entrega de tarjeta 
    dataCreditCard.setDeliveryAddress(dtoRequest.getDeliveryAddress());

    //notificacion correo
    dataCreditCard.setEmailNotifications(dtoRequest.getEmailNotifications());

    //notificacion sms
    dataCreditCard.setSmsNotifications(dtoRequest.getSmsNotifications());

    //indica si quiere tarjeta fisica 
    dataCreditCard.setDigitalCard(dtoRequest.getDigitalCard());

    //cupo calculado
    dataCreditCard.setEstimatedCreditLimit(impEstimatedCreditLimit.estimatedCreditLimit(dtoRequest));

    //fecha de la peticion
    dataCreditCard.setFechaSolicitud(dtoRequest.getFechaSolicitud());

    //estado
    dataCreditCard.setEstado("ACTIVO");

    ModelCreditCardReference dataReference = impMapRequestCreditCardReference.mapCreditCardReference(dtoRequest);

    dataCreditCard.setReference(dataReference);

    return dataCreditCard;

   } 

}
