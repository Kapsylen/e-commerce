package com.homebrew.ecommerce.infrastructure;

import com.homebrew.ecommerce.infrastructure.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
