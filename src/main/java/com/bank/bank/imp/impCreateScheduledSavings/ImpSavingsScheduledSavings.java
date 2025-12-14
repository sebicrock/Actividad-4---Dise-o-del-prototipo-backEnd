package com.bank.bank.imp.impCreateScheduledSavings;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoRequestCreateScheduledSavings;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoScheduledSavings;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.model.modelScheduledSavings.ModelScheduledSavings; 
import com.bank.bank.repository.repositoryScheduledSavings.RepositoryCreateScheduledSavings;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpSavingsScheduledSavings {

    private final ImpCalculatedPayment impCalculatedPayment;
    private final ImpEstimatedInterest impEstimatedInterest;        
    private final ImpTotalWithInterest impTotalWithInterest;
    private final ImpValidationRequestCreateScheduledSavings impValidationRequestCreateScheduledSavings;
    private final ImpCalculeNumberOfPayments impCalculeNumberOfPayments;
    private final ImpMapRequestCreateScheduledSavings impMapRequestCreateScheduledSavings;
    private final RepositoryCreateScheduledSavings repositoryCreateScheduledSavings;
    private final ImpCreateNumberScheduledSavings impCreateNumberScheduledSavings;
    private final RepositoryClient repositoryClient;

    public ModelScheduledSavings savingsScheduledSavings(DtoRequestCreateScheduledSavings dtoRequest){

        impValidationRequestCreateScheduledSavings.ValidationRequestCreateScheduledSavings(dtoRequest);

        Double calculatedPayment = impCalculatedPayment.calculatedPayment(dtoRequest);
        Double estimatedInterest = impEstimatedInterest.estimatedInteres(dtoRequest);
        Double totalWithInterest = impTotalWithInterest.totalWithInterest(dtoRequest.getTargetAmount(), estimatedInterest);
        Long numberOfPayments = impCalculeNumberOfPayments.calculeNumberOfPayment(dtoRequest);

        DtoScheduledSavings dtoScheduledSavings = impMapRequestCreateScheduledSavings.impMapRequestCreateScheduledSavings(dtoRequest);

        dtoScheduledSavings.setCalculatedPayment(calculatedPayment);
        dtoScheduledSavings.setEstimatedInterest(estimatedInterest);
        dtoScheduledSavings.setTotalWithInterest(totalWithInterest);
        dtoScheduledSavings.setNumberOfPayments(numberOfPayments);

        ModelScheduledSavings modelScheduledSavings = new ModelScheduledSavings();
        modelScheduledSavings.setSavingsNumber(impCreateNumberScheduledSavings.createNumberScheduledSavings());
        modelScheduledSavings.setSavingsGoal(dtoScheduledSavings.getSavingsGoal());
        modelScheduledSavings.setTargetAmount(dtoScheduledSavings.getTargetAmount());
        modelScheduledSavings.setTermMonths(dtoScheduledSavings.getTermMonths());
        modelScheduledSavings.setFrequency(dtoScheduledSavings.getFrequency());
        modelScheduledSavings.setStartDate(dtoScheduledSavings.getStartDate());
        modelScheduledSavings.setDebitAccountType("Cuenta de ahorros");
        modelScheduledSavings.setDebitAccountNumber(dtoScheduledSavings.getDebitAccountNumber());        
        modelScheduledSavings.setBankName(dtoScheduledSavings.getBankName());
        modelScheduledSavings.setDebitDay(dtoScheduledSavings.getDebitDay());
        modelScheduledSavings.setEmailNotifications(dtoScheduledSavings.getEmailNotifications());
        modelScheduledSavings.setSmsNotifications(dtoScheduledSavings.getSmsNotifications());
        modelScheduledSavings.setGoalReminders(dtoScheduledSavings.getGoalReminders());
        modelScheduledSavings.setAcceptTerms(dtoScheduledSavings.getAcceptTerms());

        // pagos calculados 

        modelScheduledSavings.setCalculatedPayment(calculatedPayment);
        modelScheduledSavings.setNumberOfPayments(numberOfPayments);
        modelScheduledSavings.setEstimatedInterest(estimatedInterest);
        modelScheduledSavings.setTotalWithInterest(totalWithInterest);
        modelScheduledSavings.setInterestRate(dtoScheduledSavings.getInterestRate());

        modelScheduledSavings.setFechaSolicitud(LocalDate.now());
        modelScheduledSavings.setEstado("ACTIVO");

        ModelDataClient modelDataClient = repositoryClient.findById(dtoRequest.getClienteId())
        .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + dtoRequest.getClienteId()));

        modelScheduledSavings.setUsuario(modelDataClient);

        repositoryCreateScheduledSavings.save(modelScheduledSavings);



        return modelScheduledSavings;        



    }

}
