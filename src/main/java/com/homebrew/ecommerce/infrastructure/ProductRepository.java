package com.homebrew.ecommerce.infrastructure;

import com.homebrew.ecommerce.infrastructure.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
