package com.bank.bank.model.modelDataClient;

import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
import lombok.Data;

import com.bank.bank.model.modelAccount.*;
import com.bank.bank.model.modelDataUser.ModelDataUser;
import com.bank.bank.model.modelSavingsPlan.ModelDataSavingsPlan;
import com.bank.bank.model.modelSavingsPlan.ModelRequestSavingsPlan;

@Data
@Entity
@Table(name = "ModelDataClient")
public class ModelDataClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fullNames")
    private String fullNames;

    @Column(name = "fullSurNames")
    private String fullSurNames;

    @Column(name = "documentType")
    private String documentType;

    @Column(name = "documentNumber")
    private String documentNumber;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Long age;

    @Column(name = "mobilePhone")
    private Long mobilePhone;

    @Column(name = "email")
    private String email;

    @Column(name  = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "department")
    private String department;

    @Column(name = "income")
    private Double income;   // Ingreso mensual ya 

    @Column(name = "employmentStatus")
    private String employmentStatus; // Empleado, Independiente, Desempleado, Pensionado ya 

    @Column(name = "occupation")
    private String occupation; // Profesión u oficio ya

    @Column(name = "companyName")
    private String companyName; // Empresa donde trabaja ya 

    @Column(name = "yearsOfExperience")
    private Integer yearsOfExperience; // Antigüedad laboral


    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    ModelDataUser user;

    @OneToMany(mappedBy = "client")
    List<ModelAccountRequest> accountRequest;

    @OneToMany(mappedBy = "client")
    List<ModelDebitCard> card;

    @OneToMany(mappedBy = "SavingsPlanClient")
    List<ModelRequestSavingsPlan> savingPlan;

    @OneToMany(mappedBy = "dataClient")
    List<ModelDataSavingsPlan> CreatesavingPlan;

    
}
