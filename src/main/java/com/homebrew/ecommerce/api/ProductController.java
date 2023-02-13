package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.ProductApi;
import com.homebrew.ecommerce.domain.response.ProductId;
import com.homebrew.ecommerce.domain.response.ProductsApi;
import com.homebrew.ecommerce.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductServiceImpl productService;

    @GetMapping("/product/{productId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ProductApi getProduct(@PathVariable String productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/products")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ProductApi> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/products")
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<ProductId> addProducts(@RequestBody ProductsApi products) {
        return productService.saveAllProducts(products);
    }

    @DeleteMapping("/products/{productId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
    }

    @DeleteMapping("products")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteAll() {
        productService.deleteAllProducts();
    }
}
