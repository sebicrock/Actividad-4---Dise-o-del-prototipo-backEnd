package com.bank.bank.imp.impCreateClient;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestClient.DtoRequestClient;
import com.bank.bank.model.modelDataClient.ModelDataClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpMapRequestClient {

    public ModelDataClient mapRequesClient(DtoRequestClient dtoRequest){
    
          ModelDataClient modelDataClient = new ModelDataClient();
          modelDataClient.setFullNames(dtoRequest.getFullNames());
          modelDataClient.setFullSurNames(dtoRequest.getFullSurNames());
          modelDataClient.setDocumentType(dtoRequest.getDocumentType());
          modelDataClient.setDocumentNumber(dtoRequest.getDocumentNumber());
          modelDataClient.setBirthDate(dtoRequest.getBirthDate());
          modelDataClient.setGender(dtoRequest.getGender());
          modelDataClient.setAge(dtoRequest.getAge());
          modelDataClient.setMobilePhone(dtoRequest.getMobilePhone());
          modelDataClient.setEmail(dtoRequest.getEmail());
          modelDataClient.setAddress(dtoRequest.getAddress());
          modelDataClient.setCity(dtoRequest.getCity());
          modelDataClient.setDepartment(dtoRequest.getDepartment());
          modelDataClient.setIncome(dtoRequest.getIncome());
          modelDataClient.setEmploymentStatus(dtoRequest.getEmploymentStatus());
          modelDataClient.setOccupation(dtoRequest.getOccupation());
          modelDataClient.setCompanyName(dtoRequest.getCompanyName());

          return modelDataClient;

    }

}