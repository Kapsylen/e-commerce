package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.response.ShoppingCartId;
import com.homebrew.ecommerce.domain.response.ShoppingCartProductsApi;
import com.homebrew.ecommerce.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    @GetMapping("/shoppingcarts/{shoppingCartId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ShoppingCartProductsApi getShoppingCart(@PathVariable String shoppingCartId) {
        return shoppingCartService.getShoppingCart(shoppingCartId);
    }

    @PostMapping("/shoppingcarts")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ShoppingCartId addProductsIntoShoppingCart(@RequestBody ShoppingCartProductsApi shoppingCartProductsApi) {
        return shoppingCartService.addProductIntoShoppingCart(shoppingCartProductsApi);
    }

    @DeleteMapping("/shoppingcarts/{shoppingCartId}/product/{productId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteProductInShoppingCart(@PathVariable String shoppingCartId, @PathVariable String productId) {
        shoppingCartService.deleteProductInShoppingCart(shoppingCartId, productId);
    }

    @DeleteMapping("/shoppingcarts/{shoppingCartId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteShoppingCart(@PathVariable String shoppingCartId) {
        shoppingCartService.deleteShoppingCart(shoppingCartId);
    }
}