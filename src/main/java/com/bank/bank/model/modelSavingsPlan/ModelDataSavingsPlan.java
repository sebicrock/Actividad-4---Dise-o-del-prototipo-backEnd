package com.bank.bank.model.modelSavingsPlan;

import java.time.LocalDate;

import com.bank.bank.model.modelDataClient.ModelDataClient;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "modelSavingsPlan")
public class ModelDataSavingsPlan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "numberSavingsPlan")
    private Long numberSavingsPlan;

    @Column(name = "targetAmount")
    private double targetAmount;

    @Column(name = "termMonths")
    private Long termMonths;

    @Column(name = "sourseAccount")
    private Long sourseAccount;

    @Column(name = "debitDay")
    private Long debitDay;

    @Column(name = "allountExtraDeposits")
    private boolean allountExtraDeposits;

    @Column(name = "autoRenew")
    private boolean autoRenew;

    @Column(name = "createDate")
    private LocalDate creatDate;

    @Column(name = "nextPaymetDate")
    private LocalDate nextPaymetDate;

    @Column(name = "accountHolder")
    private String accountHolder;

    @Column(name = "paidInstallments")
    private Long paidInstallments;

    @Column(name = "remaningInstallments")
    private Long remaningInstallments;

    @Column(name = "accumulatedAmount")
    private double accumulatedAmount;

    @Column(name = "remainingAmount")
    private double remainingAmount;

    @Column(name = "interest")
    private double interest;

    @ManyToOne
    @JoinColumn(name = "ClientId")
    private ModelDataClient dataClient;


}
