package com.bank.bank.dto.dtoResponse.createCdts;

import com.bank.bank.model.modelDataCdts.ModelDataCdts;

import lombok.Data;

@Data
public class DtoResponseCreateCdts {

    String mensaje;
    ModelDataCdts dataCdts;


}
