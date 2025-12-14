package com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
public class DtoRequestCreateScheduledSavings {

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

    @NotBlank(message = "La meta de ahorro es obligatoria")
    @Size(min = 3, message = "La meta de ahorro debe tener al menos 3 caracteres")
    private String savingsGoal;

    @NotNull(message = "El monto objetivo es obligatorio")
    @Min(value = 100000, message = "El monto objetivo mínimo es de $100,000 COP")
    private Double targetAmount;

    @NotNull(message = "El plazo en meses es obligatorio")
    @Min(value = 1, message = "El plazo mínimo es de 1 mes")
    private Long termMonths;

    @NotBlank(message = "La frecuencia es obligatoria")
    private String frequency;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @FutureOrPresent(message = "La fecha de inicio debe ser hoy o futura")
    private LocalDate startDate;

    @NotBlank(message = "El tipo de cuenta de débito es obligatorio")
    private String debitAccountType;

    @NotBlank(message = "El número de cuenta de débito es obligatorio")
    @Size(min = 10, message = "El número de cuenta debe tener al menos 10 dígitos")
    private String debitAccountNumber;

    @NotBlank(message = "El banco es obligatorio")
    private String bankName;

    @NotNull(message = "El día de débito es obligatorio")
    @Min(value = 1, message = "El día mínimo es 1")
    @Max(value = 31, message = "El día máximo es 31")
    private Long debitDay;

    private Boolean emailNotifications = true;
    private Boolean smsNotifications = false;
    private Boolean goalReminders = true;

    @AssertTrue(message = "Debe aceptar los términos y condiciones")
    private Boolean acceptTerms;

    // Campos calculados, opcionales en el request
    private Double calculatedPayment;
    private Integer numberOfPayments;
    private Double estimatedInterest;
    private Double totalWithInterest;
    private Double interestRate;

    private LocalDate fechaSolicitud;
    private String estado;
}
