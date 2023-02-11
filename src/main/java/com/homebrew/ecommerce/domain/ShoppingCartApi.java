package com.homebrew.ecommerce.domain;

import lombok.Builder;

import java.util.List;
@Builder
public record ShoppingCartApi (
        String id,
        List<ProductApi> products
){}
