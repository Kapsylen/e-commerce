package com.homebrew.ecommerce.domain;

import lombok.Builder;

@Builder
public record ProductApi(
        String name,
        String brand
) {
}
