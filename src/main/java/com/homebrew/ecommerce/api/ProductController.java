package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.ProductApi;
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

    @PostMapping("/product")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductApi productApi) {
        productService.saveProduct(productApi);
    }

    @PostMapping("/products")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addProducts(@RequestBody List<ProductApi> products) {
        productService.saveAllProducts(products);
    }

    @DeleteMapping("/product/{productId}")
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
