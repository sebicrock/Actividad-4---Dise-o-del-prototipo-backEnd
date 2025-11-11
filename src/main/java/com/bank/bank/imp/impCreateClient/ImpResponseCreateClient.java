package com.bank.bank.imp.impCreateClient;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResponse.createClient.DtoResponseCreateClient;
import com.bank.bank.model.modelDataClient.ModelDataClient;
import com.bank.bank.model.modelDataUser.ModelDataUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpResponseCreateClient {

    public DtoResponseCreateClient responseCreateClient(ModelDataClient dataClient, ModelDataUser dataUser){

        DtoResponseCreateClient dtoResponse = new DtoResponseCreateClient();
        dtoResponse.setMensaje("Cliente creado con exito");
        dtoResponse.setNombre(dataClient.getFullNames()+" "+dataClient.getFullSurNames());
        dtoResponse.setUsuario(dataUser.getUserName());

        return dtoResponse;


    }

}
