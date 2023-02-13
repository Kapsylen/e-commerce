package com.homebrew.ecommerce.domain.response;

import com.homebrew.ecommerce.domain.ProductApi;
import lombok.Builder;

@Builder
public record ShoppingCartProductApi(
        ProductApi productApi,
        Integer quantity
) {
}
