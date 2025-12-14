package com.bank.bank.repository.repositoryScheduledSavings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelScheduledSavings.ModelScheduledSavings;


@Repository
public interface RepositoryCreateScheduledSavings extends JpaRepository<ModelScheduledSavings, Long>{
        
}
