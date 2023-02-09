package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.AddressApi;
import com.homebrew.ecommerce.domain.CustomerApi;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    public static int randomNumber() {
        return ThreadLocalRandom.current().nextInt();
    }

    public static CustomerApi randomCustomerApi() {
        return CustomerApi.builder()
                .firstName(UUID.randomUUID().toString())
                .lastName(UUID.randomUUID().toString())
                .ssn(UUID.randomUUID().toString())
                .addressApi(randomAddress())
                .build();
    }

    private static AddressApi randomAddress() {

        return AddressApi.builder()
                .city(UUID.randomUUID().toString())
                .street(UUID.randomUUID().toString())
                .zipCode(randomNumber())
                .number(randomNumber())
                .build();
    }
}