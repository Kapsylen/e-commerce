package com.homebrew.ecommerce.domain.response;

import com.homebrew.ecommerce.domain.ProductApi;
import lombok.Builder;

import java.util.List;

@Builder
public record ShoppingCartProductsApi (
        String shoppingCartId,
        List<ProductApi> productApis
){}
