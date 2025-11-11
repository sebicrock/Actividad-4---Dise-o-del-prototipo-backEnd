package com.bank.bank.imp.impCreateClient;

import org.springframework.stereotype.Service;

import com.bank.bank.dto.dtoResquest.dtoRequestClient.DtoRequestUser;
import com.bank.bank.model.modelDataUser.ModelDataUser;
import java.util.*;


@Service

public class ImpMapRequestUser {


    public ModelDataUser impMapRequestUser(List<DtoRequestUser> dtoRequestUser){

        DtoRequestUser dtoUser = dtoRequestUser.get(0);

        ModelDataUser modelDataUser = new ModelDataUser();
        modelDataUser.setUserName(dtoUser.getUserName());
        modelDataUser.setPassword(dtoUser.getPassword());
        modelDataUser.setRole(dtoUser.getRole());

        return modelDataUser;
    }


}
