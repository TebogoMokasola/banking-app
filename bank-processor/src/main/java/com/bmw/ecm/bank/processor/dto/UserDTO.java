package com.bmw.ecm.bank.processor.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class UserDTO {

    Integer id;
    String name;
    String surname;
    String email;
    String gender;
    String password;
    List<TransactionsDTO> transactions;
}
