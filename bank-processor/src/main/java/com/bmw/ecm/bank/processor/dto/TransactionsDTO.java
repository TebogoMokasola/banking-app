package com.bmw.ecm.bank.processor.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter@Setter
public class TransactionsDTO {

    Integer id;
    Integer user;
    BigDecimal amount;
    LocalDate transactionDate;
    String transactionType;
    String description;
}
