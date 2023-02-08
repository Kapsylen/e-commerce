package com.homebrew.ecommerce.domain;

import lombok.Builder;

@Builder
public record ProductApi(
        String productId,
        String name,
        int quantity
) {
}
