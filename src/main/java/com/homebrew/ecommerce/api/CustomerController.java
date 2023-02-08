package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.CustomerApi;
import com.homebrew.ecommerce.service.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/customers")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerController {

    private CustomerServiceImpl customerService;

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerApi getCustomer(@PathVariable String id) {
       return customerService.getCustomer(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody CustomerApi customerApi) {
        customerService.saveCustomer(customerApi);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
    }
    @GetMapping
    public List<CustomerApi> getAllCustomers() {
       return customerService.getCustomers();
    }
}
