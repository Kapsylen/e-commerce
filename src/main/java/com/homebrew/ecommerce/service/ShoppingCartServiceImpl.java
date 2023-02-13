package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.ShoppingCart;
import com.homebrew.ecommerce.domain.response.ShoppingCartId;
import com.homebrew.ecommerce.domain.response.ShoppingCartProductsApi;
import com.homebrew.ecommerce.infrastructure.ShoppingCartRepository;
import com.homebrew.ecommerce.util.ShoppingCartProductTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCartId addProductIntoShoppingCart(ShoppingCartProductsApi shoppingCartProductsApi) {
        if (shoppingCartProductsApi.shoppingCartId() == null) {
            var shoppingCart = new ShoppingCart(UUID.randomUUID().toString(), shoppingCartProductsApi.productApis().stream().map(ShoppingCartProductTransformer::toShoppingCartProducts).toList());
            shoppingCartRepository.save(shoppingCart);
            return ShoppingCartId.builder().shoppingCartId(shoppingCart.getId()).build();
        }
        var shoppingCart = shoppingCartRepository.findById(shoppingCartProductsApi.shoppingCartId());
        if (shoppingCart.isPresent()) {
            shoppingCart.get().getShoppingCartProducts().addAll(shoppingCartProductsApi.productApis().stream().map(ShoppingCartProductTransformer::toShoppingCartProducts).toList());
            shoppingCartRepository.save(shoppingCart.get());
            return ShoppingCartId.builder().shoppingCartId(shoppingCart.get().getId()).build();
        } else {
           return null;
        }
    }

    @Override
    public void deleteShoppingCart(String shoppingCartId) {
        var shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        if (shoppingCart.isPresent()) {
            shoppingCartRepository.deleteById(shoppingCartId);
        }
    }

    @Override
    public void deleteProductInShoppingCart(String shoppingCartId, String productId) {
        var shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        if (shoppingCart.isPresent()) {
            shoppingCart.get().getShoppingCartProducts().removeIf(p -> p.getId().equals(productId));
            shoppingCartRepository.save(shoppingCart.get());
        }
    }

    @Override
    public ShoppingCartProductsApi getShoppingCart(String shoppingCartId) {
        var shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        if (shoppingCart != null) {
            return ShoppingCartProductTransformer.toShoppingCartProductsApi(shoppingCart);
        } else {
            return null;
        }
    }
}
