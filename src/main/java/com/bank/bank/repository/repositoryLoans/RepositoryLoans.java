package com.bank.bank.repository.repositoryLoans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelDataLoan.ModelDataLoan;


@Repository
public interface RepositoryLoans extends JpaRepository<ModelDataLoan, Long> {

}
