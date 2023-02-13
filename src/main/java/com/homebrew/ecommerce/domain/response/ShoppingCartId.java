package com.homebrew.ecommerce.domain.response;

import lombok.Builder;

@Builder
public record ShoppingCartId(
   String shoppingCartId
) {}
