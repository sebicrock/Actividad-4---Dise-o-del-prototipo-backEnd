package com.bank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelAccount.ModelAccountRequest;

@Repository
public interface RepositoryAccountRequest extends JpaRepository<ModelAccountRequest,Long> {

}
