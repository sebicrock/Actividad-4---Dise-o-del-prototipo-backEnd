package com.bank.bank.imp.impCreateCdts;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestCreateCdt.DtoRequestCreateCdts;

@Service
public class ImpMaturityDateCdts {

    public LocalDate calculateMaturityDate(DtoRequestCreateCdts dtoRequestCreateCdts) {
        Long cdtTerm = dtoRequestCreateCdts.getCdtTerm();
        LocalDate openingDate = LocalDate.now();

        // Cálculo de la fecha de madurez
        LocalDate maturityDate = openingDate.plusDays(cdtTerm);

        return maturityDate;    
        
    }


}
