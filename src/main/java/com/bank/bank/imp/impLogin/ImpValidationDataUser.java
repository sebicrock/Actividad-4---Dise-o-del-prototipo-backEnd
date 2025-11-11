package com.bank.bank.imp.impLogin;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestLogin.DtoRequestLogin;
import com.bank.bank.model.modelDataUser.ModelDataUser;
import com.bank.bank.repository.respositoryCreateClient.RepositoryUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpValidationDataUser {

    private final RepositoryUser repositoryUser;



    public void validateData(DtoRequestLogin dtoRequestLogin){

        boolean user = repositoryUser.existsByUserName(dtoRequestLogin.getUserName());

        if(user == false){
            throw new IllegalArgumentException("El usuario ya se encuentra creado");
        }

        ModelDataUser dataUser = repositoryUser.findByUserName(dtoRequestLogin.getUserName());
        String dataPassword = dataUser.getPassword();

        if(!dataPassword.equals(dtoRequestLogin.getPassword())){
            throw new IllegalArgumentException("La contraseña no es correcta");
        }
        
    }

}
