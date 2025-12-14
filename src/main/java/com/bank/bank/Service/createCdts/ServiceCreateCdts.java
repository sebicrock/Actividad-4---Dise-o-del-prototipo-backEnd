package com.bank.bank.Service.createCdts;

import com.bank.bank.dto.dtoResponse.createCdts.DtoResponseCreateCdts;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateCdt.DtoRequestCreateCdts;

public interface ServiceCreateCdts {

     DtoResponseCreateCdts responseCreateCdts(DtoRequestCreateCdts dtoRequestCreateCdts);

}
