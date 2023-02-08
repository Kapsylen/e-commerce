package com.homebrew.ecommerce.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_accounts")
public class UserAccount {
    @Id
    private String id;
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public UserAccount(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}