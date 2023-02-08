package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.infrastructure.AddressRepository;

import static org.assertj.core.api.Assertions.assertThat;




public class AddressServiceTest {

    AddressServiceImpl addressService;

    AddressRepository repository;



    public void ShouldGetAddress_GivenIdWereFound() {


        var fetchedAddress = repository.findAll();
        assertThat(fetchedAddress).isNotNull();
    }
}
