package com.bank.bank.imp.impCreateAccount;

import org.springframework.stereotype.Service;

import com.bank.bank.Service.CreateAccountService;
import com.bank.bank.dto.dtoResponse.createAccount.DtoResponseCreateAccount;
import com.bank.bank.dto.dtoResquest.DtoRequestCreateAccount;
import com.bank.bank.model.modelAccount.ModelAccount;
import com.bank.bank.model.modelAccount.ModelAccountRequest;
import com.bank.bank.model.modelAccount.ModelDebitCard;
import com.bank.bank.repository.RepositoryAccountRequest;
import com.bank.bank.repository.RepositoryDebitCard;
import com.bank.bank.repository.RepositoryModelAccount;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@RequiredArgsConstructor
@Slf4j
public class ImpCreateAccount implements CreateAccountService {

    private final RepositoryModelAccount repositoryModelAccount;
    private final RepositoryDebitCard repositoryDebitCard;
    private final RepositoryAccountRequest repositoryAccountRequest;

    private final ImpValidationData impValidationData;
    private final ImpAccountFactory impAccountFactory;
    private final ImpResponseCreateAccount impResponseCreateAccount;


    @Transactional
    @Override
    
    public DtoResponseCreateAccount createAccount(DtoRequestCreateAccount dataCreateAccount){
        log.info("inicio creacion de cuenta  para el cliente id {}", dataCreateAccount.getClienteId());


        impValidationData.validatioClient(dataCreateAccount);
        log.debug("validacion de cliente completa para ID {}", dataCreateAccount.getClienteId());

        ModelAccountRequest modelAccountRequest = impAccountFactory.mapAccountReequest(dataCreateAccount);
        repositoryAccountRequest.save(modelAccountRequest);
        log.debug("solicitud de cuenta guardada: {}", modelAccountRequest);

        ModelAccount modelAccount = impAccountFactory.mapAccount(modelAccountRequest, dataCreateAccount);
        repositoryModelAccount.save(modelAccount);
        log.info("cuenta creada exitosamente con numero {}", modelAccount.getAccountNumber());

        ModelDebitCard modelDebitCard = impAccountFactory.mapDebitCard(modelAccount, dataCreateAccount);
        repositoryDebitCard.save(modelDebitCard);
        log.info("tarjeta debito asociada creda {}", modelDebitCard.getNumberCard());

        DtoResponseCreateAccount dtoResponseCreateAccount = impResponseCreateAccount.createResponse(dataCreateAccount, modelAccount, modelDebitCard);        
        log.info("proceso de creacion de cuenta finalizado para el cliente ID {}", dataCreateAccount);

        return dtoResponseCreateAccount;




    }




}
