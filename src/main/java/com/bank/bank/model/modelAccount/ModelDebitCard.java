package com.bank.bank.model.modelAccount;

import jakarta.persistence.Entity;

import java.time.LocalDate;

import com.bank.bank.model.modelDataClient.ModelDataClient;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DebitCard")
public class ModelDebitCard {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "linkenAccount")
    private Long linkenAccount;

    @Column(name = "numberCard")
    private Long numberCard;

    @Column(name = "typeCard")
    private String  typeCard;

    @Column(name = "stateCard")
    private Boolean stateCard;

    @Column(name = "expirationDate")
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "clienId")
    ModelDataClient client;

    @ManyToOne
    @JoinColumn(name = "clientId")
    ModelAccount clien;

    


}
