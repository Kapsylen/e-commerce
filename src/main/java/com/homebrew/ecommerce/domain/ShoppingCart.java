package com.homebrew.ecommerce.domain;

import com.homebrew.ecommerce.infrastructure.entity.ShoppingCartProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shopping_carts")
public class ShoppingCart {
    @Id
    String id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
    List<ShoppingCartProduct> shoppingCartProducts = new ArrayList<>();
}
