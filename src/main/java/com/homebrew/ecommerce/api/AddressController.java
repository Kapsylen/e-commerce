package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.AddressApi;
import com.homebrew.ecommerce.service.AddressServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController("/addresses")
@NoArgsConstructor
@AllArgsConstructor
public class AddressController {

    private AddressServiceImpl addressService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addAddress(@RequestBody AddressApi addressApi) {
        addressService.saveAddress(addressApi);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteAddress(@PathVariable String id) {
        addressService.deleteAddress(id);
    }
}