package com.bank.bank.imp.impCreateCdts;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateCdt.DtoRequestCreateCdts;
import com.bank.bank.model.modelDataCdts.ModelDataCdts;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpMapRequestCdts {

    private final ImpGenerateNumberCdts impGenerateNumberCdts;
    private final ImpTotalInterestCdts impTotalInterestCdts;
    private final ImpMaturityAmount impMaturityAmount;
    private final ImpMaturityDateCdts impMaturityDateCdts;

    public ModelDataCdts mapDataCdts(DtoRequestCreateCdts dtoRequestCreateCdts) {

        ModelDataCdts dataCdts = new ModelDataCdts();

        // numero del cdt
        dataCdts.setCdtNumber(impGenerateNumberCdts.generateNumbreCdts(dtoRequestCreateCdts.getClienteId()));


        // cliente id
        dataCdts.setClienteId(dtoRequestCreateCdts.getClienteId());
        // datos del cdt
        dataCdts.setCdtAmount(dtoRequestCreateCdts.getCdtAmount());
        // Plazo en días (30, 60, 90, etc.)
        dataCdts.setCdtTerm(dtoRequestCreateCdts.getCdtTerm());
        // MENSUAL | TRIMESTRAL | SEMESTRAL | VENCIMIENTO
        dataCdts.setCdtType(dtoRequestCreateCdts.getCdtType());
        // Cuenta de origen
        dataCdts.setSourceAccountType(dtoRequestCreateCdts.getSourceAccountType());
        // nombre de banco de la cuenta de origen
        dataCdts.setSourceBankName(dtoRequestCreateCdts.getSourceBankName());
        // tipo de cuenta de intereses
        dataCdts.setInterestAccountType(dtoRequestCreateCdts.getInterestAccountType());
        // número de cuenta de origen
        dataCdts.setInterestAccountNumber(dtoRequestCreateCdts.getInterestAccountNumber());
        // auto renovación
        dataCdts.setAutoRenewal(dtoRequestCreateCdts.isAutoRenewal());
        // notificaciones por email
        dataCdts.setEmailNotifications(dtoRequestCreateCdts.isEmailNotifications());
        // certificado físico
        dataCdts.setPhysicalCertificate(dtoRequestCreateCdts.isPhysicalCertificate());
        // términos y condiciones
        dataCdts.setAcceptTerms(dtoRequestCreateCdts.isAcceptTerms());
        // interes   
        dataCdts.setInterestPayment(dtoRequestCreateCdts.getInterestPayment());
        // 
        dataCdts.setSourceAccountNumber(dtoRequestCreateCdts.getSourceAccountNumber());

        // Campos calculados

        // Tasa de interés según tipo de CDT y plazo
        dataCdts.setInterestRate(dtoRequestCreateCdts.getInterestRate());
        // Fecha de interes
        dataCdts.setOpeningDate(LocalDate.now());
        // Estado del CDT
        dataCdts.setEstado("ACTIVO");
        // Interés total
        dataCdts.setTotalInterest(impTotalInterestCdts.calculateTotalInterest(dtoRequestCreateCdts));
        // Monto a la madurez
        dataCdts.setMaturityAmount(impMaturityAmount.calculateMaturityAmount(dtoRequestCreateCdts));
        // Fecha de madurez
        dataCdts.setMaturityDate(impMaturityDateCdts.calculateMaturityDate(dtoRequestCreateCdts));


        return dataCdts;


    }
}