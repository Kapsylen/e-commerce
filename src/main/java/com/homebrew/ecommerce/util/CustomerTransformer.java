package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.CustomerApi;
import com.homebrew.ecommerce.infrastructure.entity.Customer;

import java.util.UUID;

import static com.homebrew.ecommerce.util.AddressTransformer.toAddress;

public class CustomerTransformer {
    public static CustomerApi toCustomerApi(Customer customer) {
        return CustomerApi.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .ssn(customer.getSsn())
                .addressApi(AddressTransformer.toAddressApi(customer.getAddress()))
                .build();
    }

    public static Customer toCustomer(CustomerApi customerApi) {
        return new Customer(UUID.randomUUID().toString(), customerApi.firstName(), customerApi.lastName(), customerApi.ssn(), toAddress(customerApi.addressApi()));
    }
}
