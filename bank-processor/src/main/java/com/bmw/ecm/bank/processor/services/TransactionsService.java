package com.bmw.ecm.bank.processor.services;

import com.bmw.ecm.bank.processor.builder.TransactionsBuilder;
import com.bmw.ecm.bank.processor.dto.TransactionsDTO;
import com.bmw.ecm.bank.processor.entities.TransactionsEntity;
import com.bmw.ecm.bank.processor.repository.TransactionsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

    private final TransactionsRepository transactionsRepository;
    private final TransactionsBuilder transactionsBuilder;

    public TransactionsService(TransactionsRepository transactionsRepository, TransactionsBuilder transactionsBuilder) {
        this.transactionsRepository = transactionsRepository;
        this.transactionsBuilder = transactionsBuilder;
    }

    public Page<TransactionsDTO> getTransactions(Specification<TransactionsEntity> sec, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TransactionsEntity> transactionsEntityPage = transactionsRepository.findAll(sec, pageable);
        return transactionsEntityPage.map(transactionsBuilder ::convertEntityToDTO);
    }

    public Page<TransactionsDTO> getWithdrawals(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TransactionsEntity> transactionsEntityPage = transactionsRepository.findByTransactionTypeEqualsIgnoreCase(pageable, "WITHDRAWAL");
        return transactionsEntityPage.map(transactionsBuilder ::convertEntityToDTO);
    }

    public Page<TransactionsDTO> getDeposits(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TransactionsEntity> transactionsEntityPage = transactionsRepository.findByTransactionTypeEqualsIgnoreCase(pageable, "WITHDRAWAL");
        return transactionsEntityPage.map(transactionsBuilder ::convertEntityToDTO);
    }

}
