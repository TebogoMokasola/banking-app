package com.bmw.ecm.bank.processor.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

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

    @Getter @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TransactionsEntity> transactions; // Establish One-to-Many relationship

    @Override
    public String toString() {
        return id.toString();
    }

}
