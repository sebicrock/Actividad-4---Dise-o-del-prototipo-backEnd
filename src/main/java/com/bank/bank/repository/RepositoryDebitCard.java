package com.bank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelAccount.ModelDebitCard;

@Repository
public interface RepositoryDebitCard  extends JpaRepository<ModelDebitCard,Long> {


    ModelDebitCard findTopByOrderByIdDesc();

    @Query(value ="SELECT * FROM pruebas01.debit_card m WHERE m.linken_account = :numberAccount",nativeQuery = true)
    ModelDebitCard findbyNumbeCard(@Param("numberAccount") Long numberCard);
}
