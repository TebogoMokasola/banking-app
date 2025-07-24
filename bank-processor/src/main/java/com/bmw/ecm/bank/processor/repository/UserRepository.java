package com.bmw.ecm.bank.processor.repository;

import com.bmw.ecm.bank.processor.entities.UsersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<UsersEntity, Integer>, JpaSpecificationExecutor<UsersEntity> {
 Page<UsersEntity> findDistinctByTransactionsIsNotEmpty(Pageable pageable);
}


