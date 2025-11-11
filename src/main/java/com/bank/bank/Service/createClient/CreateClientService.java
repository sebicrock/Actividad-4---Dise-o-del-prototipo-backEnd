package com.bank.bank.Service.createClient;

import com.bank.bank.dto.dtoResponse.createClient.DtoResponseCreateClient;
import com.bank.bank.dto.dtoResquest.dtoRequestClient.DtoRequestClient;


public interface CreateClientService {

    DtoResponseCreateClient createClient(DtoRequestClient dataClient);

}
