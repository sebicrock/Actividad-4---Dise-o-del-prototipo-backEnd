package com.bank.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.Service.CreateAccountService;
import com.bank.bank.Service.CreateSavingsPlanService;
import com.bank.bank.Service.GetDataAccountService;
import com.bank.bank.Service.createClient.CreateClientService;
import com.bank.bank.dto.dtoResponse.createAccount.DtoResponseCreateAccount;
import com.bank.bank.dto.dtoResponse.createClient.DtoResponseCreateClient;
import com.bank.bank.dto.dtoResponse.createSavings.DtoResponseSavingsPlan;
import com.bank.bank.dto.dtoResponse.getDataAccount.DtoResponseGetDataAccount;
import com.bank.bank.dto.dtoResponse.getDataClient.DtoResponseGetDataClient;
import com.bank.bank.dto.dtoResponse.login.DtoResponseLogin;
import com.bank.bank.dto.dtoResquest.DtoRequestCreateAccount;
import com.bank.bank.dto.dtoResquest.DtoRequestCreateRecurringSavingsAccount;
import com.bank.bank.dto.dtoResquest.dtoRequestClient.DtoRequestClient;
import com.bank.bank.dto.dtoResquest.dtoRequestLogin.DtoRequestLogin;
import com.bank.bank.imp.ImpGetDataClient;
import com.bank.bank.imp.impLogin.ImpLogin;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/bank")
public class ControllerClient {

    private final CreateClientService createClientService;

    
    private final ImpLogin impLogin;

    @Autowired
    ImpGetDataClient impGetDataClient;

    @Autowired
    CreateAccountService createAccountService;

    @Autowired
    GetDataAccountService getDataAccountService;

    @Autowired
    CreateSavingsPlanService createSavingsPlanService;

    @PostMapping("/createClient")
    public ResponseEntity<DtoResponseCreateClient> createClient(@RequestHeader(name = "token", required = false) String token,@Valid @RequestBody DtoRequestClient dataClient){
        
        return new ResponseEntity<>(createClientService.createClient(dataClient), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<DtoResponseLogin> login(@RequestHeader(name = "token", required = false)String token,@Valid @RequestBody DtoRequestLogin DataLogin){
        return new ResponseEntity<>(impLogin.validateLogin(DataLogin), HttpStatus.ACCEPTED);
    }

    @GetMapping("clientes/{clientId}")
    public ResponseEntity<DtoResponseGetDataClient> getDataClient(@PathVariable Long clientId){

        return new  ResponseEntity<>(impGetDataClient.getDataClient(clientId), HttpStatus.OK);
        
    }

    @PostMapping("/CreateAccount")
    public ResponseEntity<DtoResponseCreateAccount> createAccount(@RequestHeader (name = "token", required = false)String token,@Valid @RequestBody DtoRequestCreateAccount dataAccount){

        return new ResponseEntity<>(createAccountService.createAccount(dataAccount), HttpStatus.OK);

    }

    @GetMapping("/cuentas/{numberAccount}")
    public ResponseEntity<DtoResponseGetDataAccount> getDataAccount(@PathVariable Long numberAccount){

        return new ResponseEntity<>(getDataAccountService.getDataAccount(numberAccount), HttpStatus.OK);

    }

    @PostMapping("/ahorro-programado/crear")
    public ResponseEntity<DtoResponseSavingsPlan>createSavingsPlan(@RequestHeader(name = "token",required = false)String token,@Valid @RequestBody DtoRequestCreateRecurringSavingsAccount dataSavings){

        return new ResponseEntity<>(createSavingsPlanService.createSavingsPlan(dataSavings), HttpStatus.CREATED);
    }  





}
