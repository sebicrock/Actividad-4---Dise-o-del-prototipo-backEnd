package com.bank.bank.repository.respositoryCreateClient;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.model.modelDataUser.ModelDataUser;

@Repository
public interface RepositoryUser extends JpaRepository<ModelDataUser,Long> {
    
    ModelDataUser findByUserName(String userName);

    boolean existsByUserName(String userName);

    ModelDataUser findByPassword(String password);

    
}
