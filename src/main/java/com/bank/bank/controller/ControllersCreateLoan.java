package com.bank.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.Service.CreateLoan.ServiceCreateLoan;
import com.bank.bank.dto.dtoResponse.createLoan.DtoResponseCreatLoan;
import com.bank.bank.dto.dtoResquest.dtoRequestLoan.DtoRequestCreateLoan;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bank")
@AllArgsConstructor
public class ControllersCreateLoan {

    private final ServiceCreateLoan serviceCreateLoan;

    @PostMapping("/createLoan")
    public ResponseEntity<DtoResponseCreatLoan> createLoan(@RequestBody @Valid DtoRequestCreateLoan dtoRequest){
        return new ResponseEntity<>(serviceCreateLoan.responseCreateLoan(dtoRequest),HttpStatus.CREATED);
    }

}
