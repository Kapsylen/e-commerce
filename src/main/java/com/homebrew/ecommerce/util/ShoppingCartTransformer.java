package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.ShoppingCart;
import com.homebrew.ecommerce.domain.ShoppingCartApi;

import java.util.UUID;

public class ShoppingCartTransformer {

    public static ShoppingCart toShoppingCart(ShoppingCartApi shoppingCartApi) {
        return new ShoppingCart(UUID.randomUUID().toString(), shoppingCartApi.products().stream().map(ProductTransformer::toProduct).toList());
    }

    public static ShoppingCartApi toShoppingCartApi(ShoppingCart shoppingCart) {
        return ShoppingCartApi.builder()
                .id(shoppingCart.getId())
                .products(shoppingCart.getProducts().stream().map(ProductTransformer::toProductApi).toList())
                .build();
    }
}
