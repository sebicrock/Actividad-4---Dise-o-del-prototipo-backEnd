package com.bank.bank.imp.impLogin;


import org.springframework.stereotype.Service;

import com.bank.bank.Service.login.ValidationLoginService;
import com.bank.bank.dto.dtoResponse.login.*;
import com.bank.bank.dto.dtoResquest.dtoRequestLogin.DtoRequestLogin;


import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ImpLogin implements ValidationLoginService{

    

    private final ImpValidationDataUser impValidationDataUser;
    private final ImpCreateResponse impCreateResponse;

    public DtoResponseLogin validateLogin(DtoRequestLogin dtoRequestLogin){

        impValidationDataUser.validateData(dtoRequestLogin);

        DtoResponseLogin dtoresponse = impCreateResponse.createResponse(dtoRequestLogin);

        return dtoresponse;

    } 


}
