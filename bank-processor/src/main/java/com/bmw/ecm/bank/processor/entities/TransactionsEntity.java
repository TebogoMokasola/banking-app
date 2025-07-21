package com.bmw.ecm.bank.processor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions", schema = "BANKING")
@Getter@Setter
public class TransactionsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

     @Column(nullable = false, name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UsersEntity user;

    @Column(nullable = false)
    BigDecimal amount;

    @Column(nullable = false, name ="transaction_date")
    LocalDate transactionDate;

    @Column(nullable = false, name ="transaction_type")
    String transactionType;

    @Column(nullable = false)
    String description;

}

