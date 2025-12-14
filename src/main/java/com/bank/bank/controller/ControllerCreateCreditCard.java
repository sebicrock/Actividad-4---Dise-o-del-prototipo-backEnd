package com.bank.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.Service.createCreditCard.ServiceCreateCreditCard;
import com.bank.bank.dto.dtoResponse.createCreditCard.DtoResponseCreateCreditCard;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateCreditCard.DtoRequestCreateCreditCard;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bank")
@AllArgsConstructor
public class ControllerCreateCreditCard {

    private final ServiceCreateCreditCard serviceCreateCreditCard;

    @PostMapping("/createCreditCard")
    public ResponseEntity<DtoResponseCreateCreditCard> createCreditCard(@RequestBody @Valid DtoRequestCreateCreditCard dtorRequest){
        return new ResponseEntity<>(serviceCreateCreditCard.createCreditCard(dtorRequest),HttpStatus.CREATED);
    }

}
