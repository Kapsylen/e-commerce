package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.CustomerApi;
import com.homebrew.ecommerce.infrastructure.entity.Customer;

public class CustomerTransformer {
    public static CustomerApi toCustomerApi(Customer customer) {
        return CustomerApi.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .ssn(customer.getSsn())
                .build();
    }

    public static Customer toCustomer(CustomerApi customerApi) {
        return new Customer(customerApi.customerId(), customerApi.firstName(), customerApi.lastName(), customerApi.ssn());
    }
}
