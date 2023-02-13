package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.CustomerApi;
import com.homebrew.ecommerce.service.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerServiceImpl customerService;

    @GetMapping("/customers/{customerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerApi getCustomer(@PathVariable String customerId) {
       return customerService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addCustomer(@RequestBody CustomerApi customerApi) {
        customerService.saveCustomer(customerApi);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }
    @GetMapping("/customers")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CustomerApi> getAllCustomers() {
       return customerService.getCustomers();
    }
}
