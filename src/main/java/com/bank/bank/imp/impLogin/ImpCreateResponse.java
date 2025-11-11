package com.bank.bank.imp.impLogin;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResponse.login.DtoResponseLogin;
import com.bank.bank.dto.dtoResquest.dtoRequestLogin.DtoRequestLogin;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.model.modelDataUser.ModelDataUser;
import com.bank.bank.repository.respositoryCreateClient.RepositoryUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpCreateResponse {


    private final RepositoryUser repositoryUser;

    public DtoResponseLogin createResponse(DtoRequestLogin requestLogin){


        ModelDataUser dataUser = repositoryUser.findByUserName(requestLogin.getUserName());
        ModelDataClient dataClient = dataUser.getClient();

        DtoResponseLogin dtoResponseLogin = new DtoResponseLogin();
        dtoResponseLogin.setMensaje("Inicio de sesion exitoso");
        dtoResponseLogin.setClienteId(dataClient.getId());
        dtoResponseLogin.setNombre(dataClient.getFullNames()+" "+dataClient.getFullSurNames());

        return dtoResponseLogin;


    }

}
