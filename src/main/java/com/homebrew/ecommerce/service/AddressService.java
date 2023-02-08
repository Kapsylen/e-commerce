package com.homebrew.ecommerce.service;


import com.homebrew.ecommerce.domain.AddressApi;

public interface AddressService {
    AddressApi getAddress(String id);
    void saveAddress(AddressApi addressApi);
    void deleteAddress(String id);
}
