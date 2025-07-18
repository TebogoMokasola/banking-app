package com.bmw.ecm.bank.processor.builder;

import com.bmw.ecm.bank.processor.dto.TransactionsDTO;
import com.bmw.ecm.bank.processor.entities.TransactionsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionsBuilder {

    private final ModelMapper modelMapper;

    public TransactionsBuilder(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TransactionsDTO convertEntityToDTO(TransactionsEntity transactions) {

        return modelMapper.map(transactions, TransactionsDTO.class);
    }
}
