package com.bank.bank.model.modelDataLoan;

import java.time.LocalDate;
import java.util.List;

import com.bank.bank.model.modelDataClient.ModelDataClient;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "model_data_loan")
public class ModelDataLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numberLoan;

    @Column(nullable = false)
    private Long loanAmount;

    @Column(nullable = false)
    private Long loanTerm;

    @Column(nullable = false)
    private String loanPurpose;

    @Column(nullable = false)
    private String employmentType;

    @Column(nullable = false)
    private Long monthlyIncome;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String timeInJob;

    @Column(nullable = false)
    private String accountType;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private boolean acceptTerms;

    @Column(nullable = false)
    private Double monthlyPayment;

    @Column(nullable = false)
    private Double interestRate;

    @Column(nullable = false)
    private Double totalInterest;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private LocalDate fechaSolicitud;

    @Column(nullable = false)
    private String estado;

    // 🔹 Referencias del préstamo
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "loan_id")
    private List<ModelLoanReference> references;

    // 🔹 Muchos préstamos → Un cliente
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ModelDataClient clientLoan;
}
