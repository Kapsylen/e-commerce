package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.AddressApi;
import com.homebrew.ecommerce.infrastructure.AddressRepository;
import com.homebrew.ecommerce.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:application-test.yml")
public class AddressService_IT {

    AddressServiceImpl addressService;

    @Autowired
    AddressRepository repository;

    @BeforeEach
    void setUp() {
        addressService = new AddressServiceImpl(repository);
    }

    @Test
    public void ShouldSaveAddress() {
        var addressApi = AddressApi.builder()
                .city(UUID.randomUUID().toString())
                .zipCode(TestData.randomNumber())
                .street(UUID.randomUUID().toString())
                .build();
        addressService.saveAddress(addressApi);

        var fetchedAddress = repository.findAll();
        assertThat(fetchedAddress).isNotNull();
    }
}
