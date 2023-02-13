package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.domain.ShoppingCart;
import com.homebrew.ecommerce.domain.response.ShoppingCartProductsApi;
import com.homebrew.ecommerce.infrastructure.entity.ShoppingCartProduct;

public class ShoppingCartProductTransformer {


    public static ShoppingCartProductsApi toShoppingCartProductsApi(ShoppingCart shoppingCart) {
        return ShoppingCartProductsApi.builder()
                .shoppingCartId(shoppingCart.getId())
                .productApis(shoppingCart.getShoppingCartProducts().stream().map(ShoppingCartProductTransformer::toProductsApi).toList())
                .build();
    }

    public static ShoppingCartProduct toShoppingCartProducts(ProductApi productApi) {
        return new ShoppingCartProduct(productApi.id(), productApi.name(), productApi.brand(), productApi.quantity());
    }

    private static ProductApi toProductsApi(ShoppingCartProduct shoppingCartProduct) {
        return ProductApi.builder()
                .id(shoppingCartProduct.getId())
                .name(shoppingCartProduct.getName())
                .brand(shoppingCartProduct.getBrand())
                .quantity(shoppingCartProduct.getQuantity())
                .build();
    }
}