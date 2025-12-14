package com.bank.bank.repository.repositoryCreditCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelCreditCard.ModelDataCreditCard;

@Repository
public interface RepositoryCreditCard extends JpaRepository<ModelDataCreditCard,Long> {

}
