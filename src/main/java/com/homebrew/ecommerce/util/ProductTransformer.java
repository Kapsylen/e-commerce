package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.infrastructure.entity.Product;

import java.util.UUID;

public class ProductTransformer {

    public static ProductApi toProductApi(Product product) {
        return ProductApi.builder()
                .name(product.getName())
                .id(product.getId())
                .quantity(product.getQuantity())
                .build();
    }

    public static Product toProduct(ProductApi productApi) {
        return new Product(UUID.randomUUID().toString(), productApi.name(), productApi.quantity());
    }
}
