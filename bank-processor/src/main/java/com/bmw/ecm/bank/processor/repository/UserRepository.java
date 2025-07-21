package com.bmw.ecm.bank.processor.repository;

import com.bmw.ecm.bank.processor.entities.UsersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
    Page<UsersEntity> findDistinctByTransactionsIsNotEmpty(Pageable pageable);
}
