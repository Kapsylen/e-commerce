package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.infrastructure.ProductRepository;
import com.homebrew.ecommerce.infrastructure.entity.Product;
import com.homebrew.ecommerce.util.ProductTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.homebrew.ecommerce.util.ProductTransformer.toProductApi;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Override
    public ProductApi getProduct(String id) {
        return toProductApi(productRepository.findById(id).get());
    }

    @Override
    public List<ProductApi> getProducts() {
        return productRepository.findAll().stream().map(ProductTransformer::toProductApi).toList();
    }

    @Override
    public void saveProduct(ProductApi productApi) {
        productRepository.save(ProductTransformer.toProduct(productApi));
    }

    @Override
    public void saveAllProducts(List<ProductApi> productApis) {
        List<Product> products = productApis.stream().map(ProductTransformer::toProduct).toList();
        productRepository.saveAll(products);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}