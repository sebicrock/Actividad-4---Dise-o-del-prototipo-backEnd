package com.bank.bank.model.modelCreditCard;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "model_data_credit_cart")
public class ModelDataCreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID de la solicitud de tarjeta de crédito

    private Long clienteId; // ID del cliente que solicita la tarjeta

    private String numbrerCard; // numero de tarjeta

    private String cardType; // Tipo de tarjeta solicitada (CLASICA, ORO, PLATINUM)
    
    private String employmentType; // Tipo de empleo del solicitante (dependiente, independiente, etc.)
    
    private String hasCreditCards; // Indica si tiene otras tarjetas de crédito (SI/NO)
    
    private Double totalCreditLimit; // Total del límite de crédito de otras tarjetas
    
    private String hasLoans; // Indica si tiene créditos activos (SI/NO)
    
    private Double monthlyLoanPayment; // Pago mensual de créditos activos
    
    private String bankReference; // Banco de referencia del solicitante
    
    private String cardDesign; // Diseño de la tarjeta (ESTANDAR, PERSONALIZADO, etc.)
    
    private String deliveryAddress; // Dirección de entrega de la tarjeta (RESIDENCIA, TRABAJO, etc.)
    
    private Boolean emailNotifications; // Indica si quiere notificaciones por correo electrónico
    
    private Boolean smsNotifications; // Indica si quiere notificaciones por SMS
    
    private Boolean digitalCard; // Indica si quiere tarjeta digital
    
    private Boolean acceptTerms; // Indica si aceptó los términos y condiciones
    
    private Double estimatedCreditLimit; // Cupo estimado calculado por el sistema
    
    private LocalDate fechaSolicitud; // Fecha de la solicitud de tarjeta
    
    private String estado; // Estado de la solicitud (PENDIENTE_APROBACION, APROBADA, RECHAZADA)

    // Relación OneToOne con referencia personal
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reference_id", referencedColumnName = "id")
    private ModelCreditCardReference reference; // Datos de la referencia


}