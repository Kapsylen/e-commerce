package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.CustomerApi;
import com.homebrew.ecommerce.infrastructure.CustomerRepository;
import com.homebrew.ecommerce.util.CustomerTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;


    @Override
    public CustomerApi getCustomer(String id) {
        return CustomerTransformer.toCustomerApi(customerRepository.findById(id).get());
    }

    @Override
    public void saveCustomer(CustomerApi customerApi) {
        customerRepository.save(CustomerTransformer.toCustomer(customerApi));
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerApi> getCustomers() {
        return customerRepository.findAll().stream().map(CustomerTransformer::toCustomerApi).toList();
    }
}
