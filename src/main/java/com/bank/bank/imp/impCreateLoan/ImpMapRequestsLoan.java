package com.bank.bank.imp.impCreateLoan;

import java.time.LocalDate;


import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestLoan.DtoRequestCreateLoan;
import com.bank.bank.model.modelDataLoan.ModelDataLoan;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpMapRequestsLoan {

    private final ImpLoanMonthlyPayment impLoanMonthlyPayment;
    private final ImpTotalInterestLoan impTotalInterestLoan;
    private final ImpGenerateNumberLoan impGenerateNumberLoan;


    public ModelDataLoan mapDataLoan(DtoRequestCreateLoan dtoRequestCreateLoan){

        ModelDataLoan modelDataLoan = new ModelDataLoan();

        modelDataLoan.setLoanAmount(dtoRequestCreateLoan.getLoanAmount());
        modelDataLoan.setLoanTerm(dtoRequestCreateLoan.getLoanTerm());
        modelDataLoan.setLoanPurpose(dtoRequestCreateLoan.getLoanPurpose());
        modelDataLoan.setEmploymentType(dtoRequestCreateLoan.getEmploymentType());
        modelDataLoan.setMonthlyIncome(dtoRequestCreateLoan.getMonthlyIncome());
        modelDataLoan.setCompanyName(dtoRequestCreateLoan.getCompanyName());
        modelDataLoan.setTimeInJob(dtoRequestCreateLoan.getTimeInJob());
        modelDataLoan.setAccountType(dtoRequestCreateLoan.getAccountType());
        modelDataLoan.setAccountNumber(dtoRequestCreateLoan.getAccountNumber());
        modelDataLoan.setBankName(dtoRequestCreateLoan.getBankName());
        modelDataLoan.setInterestRate(dtoRequestCreateLoan.getInterestRate());


        // Generar y establecer el número único del préstamo
        modelDataLoan.setNumberLoan(impGenerateNumberLoan.generateNumberLoan(dtoRequestCreateLoan.getClienteId()));


        // Establecer el estado inicial del préstamo
        modelDataLoan.setEstado("ACTIVO");

        // Calcular el pago mensual del préstamo
        modelDataLoan.setMonthlyPayment(impLoanMonthlyPayment.calculateMonthlyPayment(modelDataLoan));

        // Calcular el interés total del préstamo
        modelDataLoan.setTotalInterest(impTotalInterestLoan.calculateTotalInterest(modelDataLoan));


        // Calcular el monto total del préstamo (principal + interés)
        modelDataLoan.setTotalAmount(modelDataLoan.getLoanAmount() + modelDataLoan.getTotalInterest());


        modelDataLoan.setFechaSolicitud(LocalDate.now());



    
        return modelDataLoan;

    }

}
