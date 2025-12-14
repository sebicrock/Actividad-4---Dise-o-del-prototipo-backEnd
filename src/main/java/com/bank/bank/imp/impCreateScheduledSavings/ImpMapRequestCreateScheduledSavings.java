package com.bank.bank.imp.impCreateScheduledSavings;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoRequestCreateScheduledSavings;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoScheduledSavings;

@Service
public class ImpMapRequestCreateScheduledSavings {

    public DtoScheduledSavings impMapRequestCreateScheduledSavings(DtoRequestCreateScheduledSavings dtoRequestCreateScheduledSavings){

        DtoScheduledSavings dtoScheduledSavings = new DtoScheduledSavings();


       
        dtoScheduledSavings.setClienteId(dtoRequestCreateScheduledSavings.getClienteId());
        dtoScheduledSavings.setSavingsGoal(dtoRequestCreateScheduledSavings.getSavingsGoal());
        dtoScheduledSavings.setTargetAmount(dtoRequestCreateScheduledSavings.getTargetAmount());        
        dtoScheduledSavings.setTermMonths(dtoRequestCreateScheduledSavings.getTermMonths());
        dtoScheduledSavings.setFrequency(dtoRequestCreateScheduledSavings.getFrequency());
        dtoScheduledSavings.setStartDate(dtoRequestCreateScheduledSavings.getStartDate());
        dtoScheduledSavings.setDebitAccountType(dtoRequestCreateScheduledSavings.getDebitAccountType());
        dtoScheduledSavings.setDebitAccountNumber(dtoRequestCreateScheduledSavings.getDebitAccountNumber());
        dtoScheduledSavings.setBankName(dtoRequestCreateScheduledSavings.getBankName());
        dtoScheduledSavings.setDebitDay(dtoRequestCreateScheduledSavings.getDebitDay());
        dtoScheduledSavings.setEmailNotifications(dtoRequestCreateScheduledSavings.getEmailNotifications());
        dtoScheduledSavings.setSmsNotifications(dtoRequestCreateScheduledSavings.getSmsNotifications());
        dtoScheduledSavings.setGoalReminders(dtoRequestCreateScheduledSavings.getGoalReminders());
        dtoScheduledSavings.setAcceptTerms(dtoRequestCreateScheduledSavings.getAcceptTerms());
        dtoScheduledSavings.setInterestRate(dtoRequestCreateScheduledSavings.getInterestRate());

        return dtoScheduledSavings;



    }



}
