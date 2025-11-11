package com.bank.bank.model.modelAccount;

import java.time.LocalDate;

import com.bank.bank.model.modelDataClient.ModelDataClient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "modelDataAccountRequest")
public class ModelAccountRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "typeAccount")
    private String typeAccount;

    @Column(name = "initialDeposit")
    private double initialDeposit;

    @Column(name = "includeDebitCard")
    private Boolean includeDebitCard;

    @Column(name = "emailNotifications")
    private Boolean emailNotifications;

    @Column(name = "smsNotifications")
    private Boolean smsNotifications;

    @Column(name = "acceptTerms")
    private Boolean acceptTerms;

    @Column(name = "fechaSolicitud")
    private LocalDate fechaSolicitud;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name ="clientId")
    ModelDataClient client;


}
