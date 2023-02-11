package com.homebrew.ecommerce.infrastructure;

import com.homebrew.ecommerce.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {
}
