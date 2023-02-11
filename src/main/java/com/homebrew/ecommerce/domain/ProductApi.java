package com.homebrew.ecommerce.domain;

import lombok.Builder;

@Builder
public record ProductApi(

        String id,
        String name,
        int quantity
) {
}
