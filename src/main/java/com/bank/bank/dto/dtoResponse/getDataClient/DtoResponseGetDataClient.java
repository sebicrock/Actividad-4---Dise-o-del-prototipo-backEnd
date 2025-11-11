package com.bank.bank.dto.dtoResponse.getDataClient;

import java.time.LocalDate;



import lombok.Data;

@Data
public class DtoResponseGetDataClient {

    private Long id;
    private String fullNames;
    private String fullSurNames;
    private String documentType;
    private String documentNumber;
    private LocalDate birthDate;
    private String gender;
    private Long age;
    private Long movilePhone;
    private String email;
    private String address;
    private String city;
    private String department;
    

}
