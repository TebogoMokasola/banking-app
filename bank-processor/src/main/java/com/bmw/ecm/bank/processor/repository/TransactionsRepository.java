package com.bmw.ecm.bank.processor.repository;

import com.bmw.ecm.bank.processor.entities.TransactionsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Integer> {
    Page<TransactionsEntity> findByTransactionTypeEqualsIgnoreCase(Pageable pageable, String transactionType);
}
