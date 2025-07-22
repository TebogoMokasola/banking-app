package com.bmw.ecm.bank.processor.spec;

import com.bmw.ecm.bank.processor.entities.TransactionsEntity;
import com.bmw.ecm.bank.processor.entities.UsersEntity;
import org.springframework.data.jpa.domain.Specification;

public class TransactionSpecification {

    public static Specification<TransactionsEntity> hasTransactionType(String transactionType){
        return(root, query, cb) -> transactionType == null || transactionType.isEmpty() ? null : cb.like(cb.lower(root.get("transactionType")), "%" + transactionType.toLowerCase() + "%");
    }

//    public static Specification<TransactionsEntity> hasTransactionDate(java.util.Date transactionDate){
//        return(root, query, cb) -> transactionDate == null  ? null : cb.like(root.get("transactionDate"), "%" + transactionDate + "%");
//    }

    public static Specification<TransactionsEntity> hasTransactionDate(java.util.Date transactionDate) {
        return (root, query, cb) -> {
            if (transactionDate == null) {
                return null;
            }
            return cb.equal(root.get("transactionDate"), transactionDate);
        };
    }

}

