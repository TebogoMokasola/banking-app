package com.bmw.ecm.bank.processor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="users", schema="BANKING")
@Getter @Setter
public class UsersEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    String firstname;
    String lastname;
    String gender;
    String email;
    String username;
    String password;
    LocalDateTime created_at;

}
