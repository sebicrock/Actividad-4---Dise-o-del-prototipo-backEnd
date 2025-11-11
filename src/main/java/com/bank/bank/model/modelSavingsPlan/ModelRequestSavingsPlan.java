package com.bank.bank.model.modelSavingsPlan;

import jakarta.persistence.Entity;

import java.time.LocalDate;

import com.bank.bank.model.modelDataClient.ModelDataClient;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "RequestSavingsPlan")
public class ModelRequestSavingsPlan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "goalType")
    private String goalType;

    @Column(name = "customGoal")
    private String customGoal;

    @Column(name = "targetAmount")
    private double targetAmount;

    @Column(name = "termMonths")
    private Long termMonths;

    @Column(name = "sourseAccount")
    private Long sourseAccount;

    @Column(name = "debitDay")
    private Long debitDay;

    @Column(name = "allowExtraDeposit")
    private Boolean allowExtraDeposit;

    @Column(name = "autoRenew")
    private Boolean autoRenew;

    @Column(name = "notifications")
    private Boolean notifications;

    @Column(name = "creationDate")
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "ClientId")
    private ModelDataClient SavingsPlanClient;



}
