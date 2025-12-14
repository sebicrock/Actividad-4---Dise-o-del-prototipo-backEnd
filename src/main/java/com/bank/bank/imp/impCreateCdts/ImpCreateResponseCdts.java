package com.bank.bank.imp.impCreateCdts;

import org.springframework.stereotype.Service;

import com.bank.bank.Service.createCdts.ServiceCreateCdts;
import com.bank.bank.dto.dtoResponse.createCdts.DtoResponseCreateCdts;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateCdt.DtoRequestCreateCdts;
import com.bank.bank.model.modelDataCdts.ModelDataCdts;
import com.bank.bank.repository.repositoryCdts.RepositoryCdts;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpCreateResponseCdts implements ServiceCreateCdts {


    private final RepositoryCdts repositoryCdts;
    private final ImpValidationRequestCreateCdts impValidationRequestCreateCdts;
    private final ImpMapRequestCdts impMapRequestCdts;

    public DtoResponseCreateCdts responseCreateCdts(DtoRequestCreateCdts dtoRequestCreateCdts) {

        impValidationRequestCreateCdts.ValidateRequestCreateCdts(dtoRequestCreateCdts);

        ModelDataCdts dataCdt = impMapRequestCdts.mapDataCdts(dtoRequestCreateCdts);

        repositoryCdts.save(dataCdt);

        DtoResponseCreateCdts response = new DtoResponseCreateCdts();
        response.setMensaje("Cdt Creado con exito");
        response.setDataCdts(dataCdt);

        return response;
    }


}
