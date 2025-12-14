package com.bank.bank.dto.dtoResquest.dtoRequestCreateCdt;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank; 
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class DtoRequestCreateCdts {


    // Datos del cliente


    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;

    @NotBlank(message = "El nombre es obligatorio")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @NotBlank(message = "El tipo de documento es obligatorio")
    private String documentType;

    @NotBlank(message = "El número de documento es obligatorio")
    private String documentNumber;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no tiene un formato válido")
    private String email;

    @Pattern(
        regexp = "\\d{10}",
        message = "El teléfono debe contener exactamente 10 dígitos"
    )
    private String phone;

    // Datos del CDT

    @NotNull(message = "El monto del CDT es obligatorio")
    @Min(value = 1000000, message = "El monto mínimo del CDT es $1.000.000 COP")
    private Long cdtAmount;

    @NotNull(message = "El plazo del CDT es obligatorio")
    private Long cdtTerm; // días: 30, 60, 90, 180, 360, etc.

    @NotBlank(message = "La forma de pago de intereses es obligatoria")
    private String interestPayment; 
    // MENSUAL | TRIMESTRAL | SEMESTRAL | VENCIMIENTO

    @NotBlank(message = "El tipo de CDT es obligatorio")
    private String cdtType;
    // TRADICIONAL | CRECIENTE | INFLACION


    // Cuenta de origen

    @NotBlank(message = "El tipo de cuenta de origen es obligatorio")
    private String sourceAccountType;

    @NotBlank(message = "El número de cuenta de origen es obligatorio")
    @Size(min = 10, message = "El número de cuenta de origen debe tener al menos 10 dígitos")
    private String sourceAccountNumber;

    @NotBlank(message = "El banco de la cuenta de origen es obligatorio")
    private String sourceBankName;


    // Cuenta de pago de intereses
    @NotBlank(message = "El tipo de cuenta para intereses es obligatorio")
    private String interestAccountType;

    @NotBlank(message = "El número de cuenta para intereses es obligatorio")
    @Size(min = 10, message = "El número de cuenta para intereses debe tener al menos 10 dígitos")
    private String interestAccountNumber;


    // Configuración adicional

    private boolean autoRenewal;

    private boolean emailNotifications;

    private boolean physicalCertificate;

    @AssertTrue(message = "Debe aceptar los términos y condiciones")
    private boolean acceptTerms;


    // Campos calculados
    @NotNull(message = "La tasa de interés es obligatoria")
    private Double interestRate;

    @NotNull(message = "El rendimiento total es obligatorio")
    private Double totalInterest;

    @NotNull(message = "El monto al vencimiento es obligatorio")
    private Double maturityAmount;

    @NotNull(message = "La fecha de apertura es obligatoria")
    private LocalDate openingDate;

    @NotNull(message = "La fecha de vencimiento es obligatoria")
    private LocalDateTime maturityDate;

    @NotBlank(message = "El estado del CDT es obligatorio")
    private String estado;

}
