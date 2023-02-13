package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.response.ShoppingCartId;
import com.homebrew.ecommerce.domain.response.ShoppingCartProductsApi;

public interface ShoppingCartService {
    ShoppingCartId addProductIntoShoppingCart(ShoppingCartProductsApi shoppingCartProductsApi);
    void deleteShoppingCart(String shoppingCartId);
    void deleteProductInShoppingCart(String shoppingCartId, String productId);
    ShoppingCartProductsApi getShoppingCart(String shoppingCartId);
}
