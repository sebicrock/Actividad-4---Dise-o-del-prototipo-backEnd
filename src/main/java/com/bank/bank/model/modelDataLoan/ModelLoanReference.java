package com.bank.bank.model.modelDataLoan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "model_loan_reference")
public class ModelLoanReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;          // Nombre de la referencia
    private String phone;         // Teléfono
    private String relationship;  // Relación (amigo, familiar, etc.)
}
