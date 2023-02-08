package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.CustomerApi;
import com.homebrew.ecommerce.service.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
public class CustomerController {

    private CustomerServiceImpl customerService;

    @GetMapping("/customers/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerApi getCustomer(@PathVariable String id) {
       return customerService.getCustomer(id);
    }

    @PostMapping("/customers")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addCustomer(@RequestBody CustomerApi customerApi) {
        customerService.saveCustomer(customerApi);
    }

    @DeleteMapping("/customer/delete/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
    }
    @GetMapping("/customers")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CustomerApi> getAllCustomers() {
       return customerService.getCustomers();
    }
}
