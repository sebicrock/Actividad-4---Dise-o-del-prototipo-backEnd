package com.bank.bank.model.modelDataCdts;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity 
@Table(name = "model_data_cdts")
public class ModelDataCdts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Número único del CDT (el que devuelves al frontend)
    @Column(nullable = false, unique = true)
    private String cdtNumber;


    // Cliente


    @Column(nullable = false)
    private Long clienteId;



    // Datos del CDT

    @Column(nullable = false)
    private Long cdtAmount;

    // Plazo en días (30, 60, 90, etc.)
    @Column(nullable = false)
    private Long cdtTerm;

    // MENSUAL | TRIMESTRAL | SEMESTRAL | VENCIMIENTO
    @Column(nullable = false)
    private String interestPayment;

    // TRADICIONAL | CRECIENTE | INFLACION
    @Column(nullable = false)
    private String cdtType;

    // Cuenta de origen


    @Column(nullable = false)
    private String sourceAccountType;

    @Column(nullable = false)
    private String sourceAccountNumber;

    @Column(nullable = false)
    private String sourceBankName;

   
    // Cuenta para pago de intereses
   
    @Column(nullable = false)
    private String interestAccountType;

    @Column(nullable = false)
    private String interestAccountNumber;

    // Configuración adicional

    @Column(nullable = false)
    private boolean autoRenewal;

    @Column(nullable = false)
    private boolean emailNotifications;

    @Column(nullable = false)
    private boolean physicalCertificate;

    @Column(nullable = false)
    private boolean acceptTerms;


    // Campos financieros calculados


    // Tasa efectiva anual
    @Column(nullable = false)
    private Double interestRate;

    // Rendimiento total
    @Column(nullable = false)
    private Double totalInterest;

    // Capital + intereses
    @Column(nullable = false)
    private Double maturityAmount;


    // Fechas


    @Column(nullable = false)
    private LocalDate openingDate;

    @Column(nullable = false)
    private LocalDate maturityDate;


    // Estado del CDT


    // ACTIVO | VENCIDO | CANCELADO | RENOVADO
    @Column(nullable = false)
    private String estado;



}
