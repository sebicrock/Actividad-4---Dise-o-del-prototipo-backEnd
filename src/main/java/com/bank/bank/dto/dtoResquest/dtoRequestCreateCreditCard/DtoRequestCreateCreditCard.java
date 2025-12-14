package com.bank.bank.dto.dtoResquest.dtoRequestCreateCreditCard;

import jakarta.validation.constraints.AssertTrue;

import java.time.LocalDate;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DtoRequestCreateCreditCard {

     @NotNull(message = "El clienteId es obligatorio")
    private Long clienteId;

    @NotBlank(message = "El nombre es obligatorio")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @NotBlank(message = "El tipo de documento es obligatorio")
    private String documentType;

    @NotBlank(message = "El número de documento es obligatorio")
    private String documentNumber;

    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    private String birthDate; // Podría usar @Past para validar fecha pasada

    @NotBlank(message = "El género es obligatorio")
    private String gender;

    @Email(message = "Debe ser un correo electrónico válido")
    @NotBlank(message = "El correo es obligatorio")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos")
    private String phone;

    @NotBlank(message = "La dirección es obligatoria")
    private String address;

    @NotBlank(message = "La ciudad es obligatoria")
    private String city;

    @NotBlank(message = "El estado civil es obligatorio")
    private String maritalStatus;

    @NotBlank(message = "El tipo de tarjeta es obligatorio")
    private String cardType;

    @NotBlank(message = "El tipo de empleo es obligatorio")
    private String employmentType;

    @NotBlank(message = "La ocupación es obligatoria")
    private String occupation;

    @NotBlank(message = "El nombre de la empresa es obligatorio")
    private String companyName;

    @NotBlank(message = "El tiempo en el trabajo es obligatorio")
    private String timeInJob;

    @Min(value = 1300000, message = "El ingreso mensual debe ser al menos 1 SMMLV")
    private Double monthlyIncome;

    @Min(value = 0, message = "Los gastos mensuales no pueden ser negativos")
    private Double monthlyExpenses;

    @NotBlank(message = "Debe indicar si tiene otras tarjetas")
    private String hasCreditCards;

    private Double totalCreditLimit;

    @NotBlank(message = "Debe indicar si tiene créditos activos")
    private String hasLoans;

    private Double monthlyLoanPayment;

    @NotBlank(message = "Debe indicar el banco de referencia")
    private String bankReference;

    @NotBlank(message = "Debe indicar el nombre de la referencia")
    private String referenceName;

    @Pattern(regexp = "\\d{10}", message = "El teléfono de la referencia debe tener 10 dígitos")
    private String referencePhone;

    @NotBlank(message = "Debe indicar la relación con la referencia")
    private String referenceRelationship;

    @NotBlank(message = "Debe seleccionar un diseño de tarjeta")
    private String cardDesign;

    @NotBlank(message = "Debe indicar la dirección de entrega")
    private String deliveryAddress;

    private Boolean emailNotifications;

    private Boolean smsNotifications;

    private Boolean digitalCard;

    @AssertTrue(message = "Debe aceptar los términos y condiciones")
    private Boolean acceptTerms;

    private Double estimatedCreditLimit;

    @NotNull(message = "La fecha de solicitud es obligatoria")
    private LocalDate fechaSolicitud;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    // Objeto anidado para referencia personal
    private ReferenceDto reference;

    @Data
    public static class ReferenceDto {
        @NotBlank(message = "El nombre de la referencia es obligatorio")
        private String name;

        @Pattern(regexp = "\\d{10}", message = "El teléfono de la referencia debe tener 10 dígitos")
        private String phone;

        @NotBlank(message = "La relación con la referencia es obligatoria")
        private String relationship;
    }

}
