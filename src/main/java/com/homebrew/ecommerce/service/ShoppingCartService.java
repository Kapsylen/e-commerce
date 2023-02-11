package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.domain.ShoppingCartApi;

public interface ShoppingCartService {
    void addProductIntoShoppingCart(String shoppingCartId, ProductApi productApi);
    void deleteShoppingCart(String shoppingCartId);
    void deleteProductInShoppingCart(String shoppingCartId, String productId);
    ShoppingCartApi getShoppingCart(String shoppingCartId);
}
