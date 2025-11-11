package com.bank.bank.imp.impCreateClient;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestClient.DtoRequestClient;
import com.bank.bank.dto.dtoResquest.dtoRequestClient.DtoRequestUser;
import com.bank.bank.repository.respositoryCreateClient.RepositoryUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpValidateUser {

    private final RepositoryUser repositoryUser;

    public void validateUser(DtoRequestClient dtoRequestClient){

       List<DtoRequestUser> dataUser = dtoRequestClient.getUser();
       DtoRequestUser dtoRequest= dataUser.get(0);
        boolean existsuserName = repositoryUser.existsByUserName(dtoRequest.getUserName());
        if(existsuserName == true){
            throw new IllegalArgumentException("El nombre del ususario ya se encuentra registrado");
        }

    }


}