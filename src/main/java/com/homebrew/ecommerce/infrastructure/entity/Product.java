package com.homebrew.ecommerce.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private int quantity;
}
