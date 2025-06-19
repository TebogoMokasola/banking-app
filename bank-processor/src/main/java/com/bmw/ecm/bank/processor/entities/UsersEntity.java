package com.bmw.ecm.bank.processor.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="users", schema="BANKING")
@Data
public class UsersEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    Integer id;
    String firstname;
    String lastname;
    String gender;
    String email;
    String username;
    String password;
    LocalDateTime created_at;

}
