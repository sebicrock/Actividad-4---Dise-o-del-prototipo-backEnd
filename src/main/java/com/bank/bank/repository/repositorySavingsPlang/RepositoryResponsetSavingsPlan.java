package com.bank.bank.repository.repositorySavingsPlang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelSavingsPlan.ModelRequestSavingsPlan;

@Repository
public interface RepositoryResponsetSavingsPlan extends JpaRepository<ModelRequestSavingsPlan,Long> {

}
