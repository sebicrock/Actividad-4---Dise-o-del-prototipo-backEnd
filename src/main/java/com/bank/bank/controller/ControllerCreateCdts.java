package com.bank.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.Service.createCdts.ServiceCreateCdts;
import com.bank.bank.dto.dtoResponse.createCdts.DtoResponseCreateCdts;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateCdt.DtoRequestCreateCdts;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bank")
@AllArgsConstructor
public class ControllerCreateCdts {

    private final ServiceCreateCdts serviceCreateCdts;

    @PostMapping("/createCdts")
    public ResponseEntity<DtoResponseCreateCdts> createCdts(@RequestBody @Valid DtoRequestCreateCdts dtoRequest){
        return new ResponseEntity<>(serviceCreateCdts.responseCreateCdts(dtoRequest), HttpStatus.CREATED);
    }

}
