package com.bank.bank.dto.dtoResquest.dtoRequestClient;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class DtoRequestUser {

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String userName;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    @Pattern(regexp = "^(?i)(CLIENTE|ADMINISTRADOR)$", message = "El rol debe ser CLIENTE o ADMINISTRADOR")
    private String role;
}

