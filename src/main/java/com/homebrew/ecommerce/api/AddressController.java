package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.service.AddressServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController("/addresses")
@AllArgsConstructor
public class AddressController {

    private AddressServiceImpl addressService;

    @DeleteMapping("/{addressId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteAddress(@PathVariable String addressId) {
        addressService.deleteAddress(addressId);
    }
}