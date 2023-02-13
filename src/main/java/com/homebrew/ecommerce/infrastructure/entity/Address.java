package com.homebrew.ecommerce.infrastructure.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity(name = "addresses")
public class Address {
    @Id
    private String id;
    private String street;
    private Integer number;
    private String city;
    private Integer zipCode;

    public Address(String id, String street, Integer number, String city, Integer zipCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.zipCode = zipCode;
    }
}
