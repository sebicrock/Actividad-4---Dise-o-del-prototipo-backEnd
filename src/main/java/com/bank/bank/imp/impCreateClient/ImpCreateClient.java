package com.bank.bank.imp.impCreateClient;


import org.springframework.stereotype.Service;

import com.bank.bank.Service.createClient.CreateClientService;
import com.bank.bank.dto.dtoResponse.createClient.DtoResponseCreateClient;
import com.bank.bank.dto.dtoResquest.dtoRequestClient.DtoRequestClient;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.model.modelDataUser.ModelDataUser;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;
import com.bank.bank.repository.respositoryCreateClient.RepositoryUser;

import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class ImpCreateClient implements CreateClientService {


    private final RepositoryClient repositoryClient;
    private final RepositoryUser repositoryUser;

    private final ImpValidateDocumentClient impValidateDocumentClient;
    private final ImpValidateUser impValidateUser;
    private final ImpMapRequestClient impMapRequestClient;
    private final ImpMapRequestUser impMapRequestUser;
    private final ImpResponseCreateClient impResponseCreateClient;

    
    @Transactional
    @Override
    public DtoResponseCreateClient createClient(DtoRequestClient dataClient){

        impValidateDocumentClient.validateDocumentClient(dataClient);
        impValidateUser.validateUser(dataClient);

        ModelDataClient mapDataclient = impMapRequestClient.mapRequesClient(dataClient);
        ModelDataUser mapDataUser = impMapRequestUser.impMapRequestUser(dataClient.getUser());
        mapDataclient.setUser(mapDataUser);
        mapDataUser.setClient(mapDataclient);
        repositoryClient.save(mapDataclient);
        repositoryUser.save(mapDataUser);

        DtoResponseCreateClient dtoResponse = impResponseCreateClient.responseCreateClient(mapDataclient, mapDataUser);

        return dtoResponse;

    }


}
