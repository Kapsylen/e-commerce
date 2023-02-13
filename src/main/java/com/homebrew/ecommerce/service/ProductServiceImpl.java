package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.domain.response.ProductId;
import com.homebrew.ecommerce.domain.response.ProductsApi;
import com.homebrew.ecommerce.infrastructure.ProductRepository;
import com.homebrew.ecommerce.infrastructure.entity.Product;
import com.homebrew.ecommerce.util.ProductTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.homebrew.ecommerce.util.ProductTransformer.toProduct;
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
    public ProductsApi getProducts() {
        return ProductsApi.builder().productApis(productRepository.findAll().stream().map(ProductTransformer::toProductApi).toList()).build();
    }

    @Override
    public ProductId saveProduct(ProductApi productApi) {
        return ProductId.builder().productId(productRepository.save(toProduct(productApi)).getId()).build();
    }

    @Override
    public List<ProductId> saveAllProducts(ProductsApi productApis) {
        List<Product> products = productApis.productApis().stream().map(ProductTransformer::toProduct).toList();
        return productRepository.saveAll(products).stream().map(ProductTransformer::toProductId).toList();
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