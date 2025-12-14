package com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings;

import java.time.LocalDate;
import lombok.Data;

@Data
public class DtoScheduledSavings {


    

    private Long clienteId; // ID del cliente
    
    private String firstName; // Nombres del cliente
    
    private String lastName; // Apellidos del cliente

    private String documentType; // Tipo de documento

    private String documentNumber; // Número de documento

    private String savingsGoal; // Nombre de la meta de ahorro

    private Double targetAmount; // Monto objetivo de ahorro

    private Long termMonths; // Plazo del ahorro en meses

    private String frequency; // Frecuencia de ahorro (SEMANAL, QUINCENAL, MENSUAL)

    private LocalDate startDate; // Fecha de inicio del ahorro


    private String debitAccountType; // Tipo de cuenta de débito

    private String debitAccountNumber; // Número de cuenta de débito

    private String bankName; // Nombre del banco

    private Long debitDay; // Día del mes en que se realizará el débito

    private Boolean emailNotifications = true; // Recibir notificaciones por correo
    private Boolean smsNotifications = false; // Recibir notificaciones por SMS
    private Boolean goalReminders = true; // Recordatorios de metas

    private Boolean acceptTerms; // Aceptación de términos y condiciones


    // Campos calculados por el front pero se debe gestionar en el back end
    private Double calculatedPayment; // Pago calculado ok
    private Long numberOfPayments; // Número de pagos ok
    private Double estimatedInterest; // Interés estimado ok
    private Double totalWithInterest; // Total con intereses
    private Double interestRate; // Tasa de interés anual ok
    private LocalDate fechaSolicitud; // Fecha de solicitud
    private String estado; // Estado del ahorro programado



}
