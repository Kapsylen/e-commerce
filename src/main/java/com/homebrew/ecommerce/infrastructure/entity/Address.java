package com.homebrew.ecommerce.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    private String id;
    private String street;
    private int number;
    private String city;
    private int zipCode;
}
