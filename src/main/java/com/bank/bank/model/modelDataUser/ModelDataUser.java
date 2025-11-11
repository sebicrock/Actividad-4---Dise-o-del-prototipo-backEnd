package com.bank.bank.model.modelDataUser;

import jakarta.persistence.Entity;

import com.bank.bank.model.modelDataClient.ModelDataClient;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ModelDataUser")
public class ModelDataUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToOne
    @JoinColumn(name = "idClient")
    private ModelDataClient client;

}
