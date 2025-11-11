package com.bank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelAccount.ModelAccount;

@Repository
public interface RepositoryAccount extends JpaRepository<ModelAccount,Long> {

    @Query(value = "SELECT * FROM model_account WHERE account_number = :accountNumber", nativeQuery = true)
    ModelAccount getByAccountNumber(@Param("accountNumber") Long accountNumber);

}
