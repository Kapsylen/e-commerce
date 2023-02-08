package com.homebrew.ecommerce.infrastructure;

import com.homebrew.ecommerce.infrastructure.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
