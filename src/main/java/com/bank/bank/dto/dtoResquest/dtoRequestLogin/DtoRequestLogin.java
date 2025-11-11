package com.bank.bank.dto.dtoResquest.dtoRequestLogin;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DtoRequestLogin {


    @NotBlank(message = "los datos del ususario no pueden ser nulos")
    String userName;

    @NotBlank(message = "los datos del password no pueden ser nulos")
    String password;


}
