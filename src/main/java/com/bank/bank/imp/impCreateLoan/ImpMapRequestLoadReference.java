package com.bank.bank.imp.impCreateLoan;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestLoan.DtoRequestCreateLoan;
import com.bank.bank.model.modelDataLoan.ModelLoanReference;


@Service
public class ImpMapRequestLoadReference {

    public List<ModelLoanReference> mapLoanReference(DtoRequestCreateLoan dtoRequestCreateLoan) {
        
        
        return dtoRequestCreateLoan.getReferences()
                .stream()
                .map(referenceDto -> {
                    ModelLoanReference reference = new ModelLoanReference();
                    reference.setName(referenceDto.getName());
                    reference.setPhone(referenceDto.getPhone());
                    reference.setRelationship(referenceDto.getRelationship());
                    return reference;
                })
                .collect(Collectors.toList());




    }


}
