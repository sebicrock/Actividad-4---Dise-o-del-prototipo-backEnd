package com.bank.bank.repository.repositoryCdts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelDataCdts.ModelDataCdts;

@Repository
public interface RepositoryCdts extends JpaRepository<ModelDataCdts, Long> {

}
