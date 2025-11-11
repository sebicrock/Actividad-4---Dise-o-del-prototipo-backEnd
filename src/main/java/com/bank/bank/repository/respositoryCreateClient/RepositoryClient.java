package com.bank.bank.repository.respositoryCreateClient;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelDataClient.ModelDataClient;

@Repository
public interface RepositoryClient extends JpaRepository<ModelDataClient,Long> {

    Optional<ModelDataClient> findById(Long id);

    Optional<ModelDataClient> findByDocumentNumber(String documentNumber);
    
    boolean existsByDocumentNumber(String documentNumber);



}
