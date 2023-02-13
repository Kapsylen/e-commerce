package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.domain.ShoppingCart;
import com.homebrew.ecommerce.domain.response.ShoppingCartProductApi;
import com.homebrew.ecommerce.domain.response.ShoppingCartProductsApi;
import com.homebrew.ecommerce.infrastructure.entity.ShoppingCartProduct;

import java.util.UUID;

public class ShoppingCartProductTransformer {
    public static ShoppingCartProduct toShoppingCartProduct(ShoppingCartProductApi shoppingCartProductsApi) {
        return new ShoppingCartProduct(UUID.randomUUID().toString(), shoppingCartProductsApi.productApi().name(), shoppingCartProductsApi.quantity());
    }

    public static ShoppingCartProductsApi toShoppingCartProductsApi(ShoppingCart shoppingCart) {
        return ShoppingCartProductsApi.builder()
                .shoppingCartId(shoppingCart.getId())
                .productApiList(shoppingCart.getShoppingCartProducts().stream().map(ShoppingCartProductTransformer::toShoppingCartProductApi).toList())
                .build();
    }

    private static ShoppingCartProductApi toShoppingCartProductApi(ShoppingCartProduct shoppingCartProduct) {
        return ShoppingCartProductApi.builder()
                .productApi(ProductApi.builder().name(shoppingCartProduct.getName()).build())
                .quantity(shoppingCartProduct.getQuantity())
                .build();
    }
}