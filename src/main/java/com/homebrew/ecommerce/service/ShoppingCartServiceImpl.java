package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.domain.ShoppingCart;
import com.homebrew.ecommerce.domain.ShoppingCartApi;
import com.homebrew.ecommerce.infrastructure.ShoppingCartRepository;
import com.homebrew.ecommerce.util.ProductTransformer;
import com.homebrew.ecommerce.util.ShoppingCartTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;


    @Override
    public void addProductIntoShoppingCart(String shoppingCartId, ProductApi productApi) {
        var shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart(UUID.randomUUID().toString(), Arrays.asList(ProductTransformer.toProduct(productApi)));
            shoppingCartRepository.save(shoppingCart);
        } else {
            shoppingCart.getProducts().add(ProductTransformer.toProduct(productApi));
            shoppingCartRepository.save(shoppingCart);
        }
    }

    @Override
    public void deleteShoppingCart(String shoppingCartId) {
        var shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        if (shoppingCart != null) {
            shoppingCartRepository.delete(shoppingCart);
        }
    }

    @Override
    public void deleteProductInShoppingCart(String shoppingCartId, String productId) {
        var shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        if (shoppingCart != null) {
            shoppingCart.getProducts().removeIf(p -> p.getId().equals(productId));
        }
    }

    @Override
    public ShoppingCartApi getShoppingCart(String shoppingCartId) {
        var shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        if (shoppingCart != null) {
            return ShoppingCartTransformer.toShoppingCartApi(shoppingCart);
        } else {
            return null;
        }
    }
}
