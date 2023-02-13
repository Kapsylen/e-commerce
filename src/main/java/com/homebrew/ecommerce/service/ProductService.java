package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.domain.response.ProductId;
import com.homebrew.ecommerce.domain.response.ProductsApi;

import java.util.List;

public interface ProductService {
    ProductApi getProduct(String id);
    List<ProductApi> getProducts();
    ProductId saveProduct(ProductApi productApi);
    List<ProductId> saveAllProducts(ProductsApi productsApi);
    void deleteProduct(String id);
    void deleteAllProducts();
}
