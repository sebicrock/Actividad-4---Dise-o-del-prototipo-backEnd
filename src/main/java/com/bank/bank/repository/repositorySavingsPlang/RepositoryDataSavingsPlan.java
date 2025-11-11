package com.bank.bank.repository.repositorySavingsPlang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelSavingsPlan.ModelDataSavingsPlan;

@Repository
public interface RepositoryDataSavingsPlan extends JpaRepository<ModelDataSavingsPlan,Long>{

    ModelDataSavingsPlan findTopByOrderByIdDesc();

}
