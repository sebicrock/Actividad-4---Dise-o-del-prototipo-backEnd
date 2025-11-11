package com.bank.bank.dto.dtoResquest;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DtoRequestCreateAccount {

    @NotNull(message = "Id del cliente no puede ser nulo")
    private Long clienteId;

    @NotBlank(message = "El número de documento no puede ser nulo ni vacío")
    private String documentNumber;

    @NotBlank(message = "El tipo de cuenta de ahorros no puede ser nulo ni vacío")
    private String type;

    @NotNull(message = "El monto de depósito inicial no puede ser nulo")
    @Positive(message = "El depósito inicial debe ser mayor que cero")
    private Double initialDeposit;

    private Boolean includeDebitCard;
    private Boolean emailNotifications;
    private Boolean smsNotifications;

    @NotNull(message = "Debe aceptar los términos y condiciones")
    private Boolean acceptTerms;

    @NotBlank(message = "El estado asignado no puede ser nulo ni vacío")
    private String estado;    



}
