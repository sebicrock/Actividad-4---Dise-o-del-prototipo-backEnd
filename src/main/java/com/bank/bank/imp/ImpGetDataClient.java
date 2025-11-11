package com.bank.bank.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResponse.getDataClient.DtoResponseGetDataClient;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.repository.respositoryCreateClient.RepositoryClient;

@Service
public class ImpGetDataClient {


    @Autowired
    RepositoryClient repositoryClient;

    public DtoResponseGetDataClient getDataClient(Long clientId){

        ModelDataClient dataClient  =  repositoryClient.findById(clientId)
                                    .orElseThrow(()-> new IllegalArgumentException("id de cliente no encontrado"));

        DtoResponseGetDataClient dtoResponseGetDataClient = new DtoResponseGetDataClient();
        dtoResponseGetDataClient.setId(dataClient.getId());
        dtoResponseGetDataClient.setFullNames(dataClient.getFullNames());
        dtoResponseGetDataClient.setFullSurNames(dataClient.getFullSurNames());
        dtoResponseGetDataClient.setDocumentType(dataClient.getDocumentType());
        dtoResponseGetDataClient.setDocumentNumber(dataClient.getDocumentNumber());
        dtoResponseGetDataClient.setBirthDate(dataClient.getBirthDate());
        dtoResponseGetDataClient.setGender(dataClient.getGender());
        dtoResponseGetDataClient.setAge(dataClient.getAge());
        dtoResponseGetDataClient.setMovilePhone(dataClient.getMobilePhone());
        dtoResponseGetDataClient.setEmail(dataClient.getEmail());
        dtoResponseGetDataClient.setAddress(dataClient.getAddress());
        dtoResponseGetDataClient.setCity(dataClient.getCity());
        dtoResponseGetDataClient.setDepartment(dataClient.getDepartment());
        
        return dtoResponseGetDataClient;

    }

}
