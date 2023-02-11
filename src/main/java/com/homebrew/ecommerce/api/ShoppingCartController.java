package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.domain.ShoppingCartApi;
import com.homebrew.ecommerce.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    @GetMapping("/shoppingcart/{shoppingCartId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ShoppingCartApi getShoppingCart(@PathVariable String shoppingCartId) {
        return shoppingCartService.getShoppingCart(shoppingCartId);
    }

    @PostMapping("/shoppingcarts")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addProductIntoShoppingCart(@PathVariable String shoppingCartId, @RequestBody ProductApi productApi) {
        shoppingCartService.addProductIntoShoppingCart(shoppingCartId, productApi);
    }

    @DeleteMapping("/shoppingcart/{shoppingCartId}/product/{productId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteProductInShoppingCart(@PathVariable String shoppingCartId, @PathVariable String productId) {
        shoppingCartService.deleteProductInShoppingCart(shoppingCartId, productId);
    }

    @DeleteMapping("/shoppingcart/{shoppingCartId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteShoppingCart(@PathVariable String shoppingCartId) {
        shoppingCartService.deleteShoppingCart(shoppingCartId);
    }
}