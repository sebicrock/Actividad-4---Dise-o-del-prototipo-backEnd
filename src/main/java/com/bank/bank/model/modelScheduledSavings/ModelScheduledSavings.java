package com.bank.bank.model.modelScheduledSavings;

import java.time.LocalDate;

import com.bank.bank.model.modelDataClient.ModelDataClient;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "model_scheduled_savings")
public class ModelScheduledSavings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Datos principales

    @Column(nullable = false, unique = true)
    private String savingsNumber;

    @Column(nullable = false)
    private String savingsGoal;

    @Column(nullable = false)
    private Double targetAmount;

    @Column(nullable = false)
    private Long termMonths;

    @Column(nullable = false)
    private String frequency;

    @Column(nullable = false)
    private LocalDate startDate;


    // Cuenta de débito

    @Column(nullable = false)
    private String debitAccountType;

    @Column(nullable = false)
    private String debitAccountNumber;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private Long debitDay;


    // Notificaciones

    @Column(nullable = false)
    private Boolean emailNotifications;

    @Column(nullable = false)
    private Boolean smsNotifications;

    @Column(nullable = false)
    private Boolean goalReminders;

    @Column(nullable = false)
    private Boolean acceptTerms;


    // Valores calculados

    @Column(nullable = false)
    private Double calculatedPayment;

    @Column(nullable = false)
    private Long numberOfPayments;

    @Column(nullable = false)
    private Double estimatedInterest;

    @Column(nullable = false)
    private Double totalWithInterest;

    @Column(nullable = false)
    private Double interestRate;


    // Estado

    @Column(nullable = false)
    private LocalDate fechaSolicitud;

    @Column(nullable = false)
    private String estado;

    // Relación con cliente

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ModelDataClient usuario;
}
