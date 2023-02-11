package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.ProductApi;

import java.util.List;

public interface ProductService {
    ProductApi getProduct(String id);
    List<ProductApi> getProducts();
    void saveProduct(ProductApi productApi);
    void saveAllProducts(List<ProductApi> productApis);
    void deleteProduct(String id);
    void deleteAllProducts();
}
