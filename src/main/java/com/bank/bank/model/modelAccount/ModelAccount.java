package com.bank.bank.model.modelAccount;

import jakarta.persistence.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "ModelAccount")
public class ModelAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AccountNumber", unique = true)
    private Long accountNumber;

    @Column(name = "state")
    private Boolean state;

    @Column(name = "CurrentAccountBalance")
    private double CurrentAccountBalance;

    @Column(name = "creationDate")
    private LocalDate creationData;

    @Column(name = "linkedDebitCard")
    private Long linkedDebitCard;

    @Column(name = "typeAccount")
    private String typeAccount;

    @Column(name = "userCreate")
    private String userCreate;

    @OneToMany(mappedBy = "clien")
    List<ModelDebitCard> cards;





}
