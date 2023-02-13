package com.homebrew.ecommerce.domain.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ShoppingCartProductsApi (
        String shoppingCartId,
        List<ShoppingCartProductApi> productApiList
){}
