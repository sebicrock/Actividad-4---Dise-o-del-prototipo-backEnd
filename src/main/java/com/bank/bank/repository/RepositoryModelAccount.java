package com.bank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.bank.bank.model.modelAccount.ModelAccount;

@Repository
public interface RepositoryModelAccount extends JpaRepository<ModelAccount,Long>{

    
    ModelAccount findTopByOrderByIdDesc();

  
}
