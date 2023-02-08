package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.CustomerApi;

import java.util.List;

public interface CustomerService {
    CustomerApi getCustomer(String id);
    void saveCustomer(CustomerApi customerApi);
    void deleteCustomer(String id);
    List<CustomerApi> getCustomers();
}
