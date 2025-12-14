package com.bank.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.Service.ServiceCreateScheduledSavings;
import com.bank.bank.dto.dtoResponse.createScheduledSavings.DtoResponseCreateScheduled;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateScheduledSavings.DtoRequestCreateScheduledSavings;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bank")
@AllArgsConstructor
public class ControllerCreateScheduledSavings {

    private final ServiceCreateScheduledSavings serviceCreateScheduledSavings;

    @PostMapping("/createScheduledSavings")
    public ResponseEntity<DtoResponseCreateScheduled> createScheduledSavings(@Valid @RequestBody DtoRequestCreateScheduledSavings dtorequest) {
        // Implementation goes here
        return new ResponseEntity<>(serviceCreateScheduledSavings.createTotal(dtorequest), HttpStatus.CREATED);
    }

}
