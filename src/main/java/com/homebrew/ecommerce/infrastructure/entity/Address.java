package com.homebrew.ecommerce.infrastructure.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    private String id;
    private String street;
    private Integer number;
    private String city;
    private Integer zipCode;
}
