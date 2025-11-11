package com.bank.bank.Service.login;

import com.bank.bank.dto.dtoResponse.login.DtoResponseLogin;
import com.bank.bank.dto.dtoResquest.dtoRequestLogin.DtoRequestLogin;

public interface ValidationLoginService {

    DtoResponseLogin validateLogin(DtoRequestLogin dtoRequestLogin);

}
