package com.homebrew.ecommerce.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shopping_cart_product")
public class ShoppingCartProduct {
    @Id
    private String id;
    private String name;
    private String brand;
    private Integer quantity;
}
