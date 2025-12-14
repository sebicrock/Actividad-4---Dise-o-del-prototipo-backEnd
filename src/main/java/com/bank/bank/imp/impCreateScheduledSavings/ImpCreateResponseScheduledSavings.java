package com.bank.bank.imp.impCreateScheduledSavings;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResponse.createScheduledSavings.DtoResponseCreateScheduled;
import com.bank.bank.dto.dtoResponse.createScheduledSavings.DtoResponseCreateScheduledSavings;
import com.bank.bank.model.modelScheduledSavings.ModelScheduledSavings;

@Service
public class ImpCreateResponseScheduledSavings {

    public DtoResponseCreateScheduled createResponseScheduledSavings(ModelScheduledSavings modelScheduledSavings){
        
        DtoResponseCreateScheduledSavings dtoResponseCreteScheduledSavings = new DtoResponseCreateScheduledSavings();

        dtoResponseCreteScheduledSavings.setSavingsNumber(modelScheduledSavings.getSavingsNumber());
        dtoResponseCreteScheduledSavings.setSavingsGoal(modelScheduledSavings.getSavingsGoal());
        dtoResponseCreteScheduledSavings.setTargetAmount(modelScheduledSavings.getTargetAmount());
        dtoResponseCreteScheduledSavings.setTermMonths(modelScheduledSavings.getTermMonths());
        dtoResponseCreteScheduledSavings.setFrequency(modelScheduledSavings.getFrequency());
        dtoResponseCreteScheduledSavings.setStartDate(modelScheduledSavings.getStartDate());
        dtoResponseCreteScheduledSavings.setDebitAccountType(modelScheduledSavings.getDebitAccountType());
        dtoResponseCreteScheduledSavings.setDebitAccountNumber(modelScheduledSavings.getDebitAccountNumber());
        dtoResponseCreteScheduledSavings.setBankName(modelScheduledSavings.getBankName());
        dtoResponseCreteScheduledSavings.setDebitDay(modelScheduledSavings.getDebitDay());
        dtoResponseCreteScheduledSavings.setEmailNotifications(modelScheduledSavings.getEmailNotifications());
        dtoResponseCreteScheduledSavings.setSmsNotifications(modelScheduledSavings.getSmsNotifications());
        dtoResponseCreteScheduledSavings.setCalculatedPayment(modelScheduledSavings.getCalculatedPayment());
        dtoResponseCreteScheduledSavings.setNumberOfPayments(modelScheduledSavings.getNumberOfPayments());
        dtoResponseCreteScheduledSavings.setEstimatedInterest(modelScheduledSavings.getEstimatedInterest());
        dtoResponseCreteScheduledSavings.setTotalWithInterest(modelScheduledSavings.getTotalWithInterest());

        DtoResponseCreateScheduled response = new DtoResponseCreateScheduled();
        response.setMensaje("Ahorro programado creado con éxito");
        response.setData(dtoResponseCreteScheduledSavings);

        return response;
    }
}
