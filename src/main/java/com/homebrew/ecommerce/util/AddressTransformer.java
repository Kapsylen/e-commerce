package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.AddressApi;
import com.homebrew.ecommerce.infrastructure.entity.Address;

import java.util.UUID;

public class AddressTransformer {
    public static AddressApi toAddressApi(Address address) {
        return AddressApi.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .build();
    }

    public static Address toAddress(AddressApi addressApi) {
        return new Address(UUID.randomUUID().toString(), addressApi.street(), addressApi.number(), addressApi.city(), addressApi.zipCode());
    }
}
