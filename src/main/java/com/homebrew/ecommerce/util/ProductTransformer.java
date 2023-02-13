package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.domain.response.ProductId;
import com.homebrew.ecommerce.infrastructure.entity.Product;

import java.util.UUID;

public class ProductTransformer {

    public static ProductApi toProductApi(Product product) {
        return ProductApi.builder()
                .name(product.getName())
                .brand(product.getBrand())
                .build();
    }

    public static Product toProduct(ProductApi productApi) {
        return new Product(UUID.randomUUID().toString(), productApi.name(), productApi.brand());
    }

    public static ProductId toProductId(Product product) {
        return ProductId.builder().productId(product.getId()).build();
    }
}