package com.bank.bank.dto.dtoResponse.createScheduledSavings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DtoResponseCreateScheduledSavings {

        // Número único del ahorro programado
    private String savingsNumber;

    // Meta de ahorro
    private String savingsGoal;

    // Monto objetivo
    private Double targetAmount;

    // Plazo en meses
    private Long termMonths;

    // Frecuencia de los pagos (SEMANAL, QUINCENAL, MENSUAL)
    private String frequency;

    // Fecha de inicio del ahorro
    private LocalDate startDate;

    // Tipo de cuenta de débito
    private String debitAccountType;

    // Número de cuenta de débito
    private String debitAccountNumber;

    // Nombre del banco
    private String bankName;

    // Día del mes en que se debita el pago
    private Long debitDay;

    // Notificación por correo electrónico
    private Boolean emailNotifications;

    // Notificación por SMS
    private Boolean smsNotifications;

    // Pago calculado por periodo
    private Double calculatedPayment;

    // Número total de pagos
    private Long numberOfPayments;

    // Interés estimado
    private Double estimatedInterest;

    // Total a pagar incluyendo interés
    private Double totalWithInterest;

}
