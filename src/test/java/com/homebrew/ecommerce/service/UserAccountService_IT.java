package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.UserAccountApi;
import com.homebrew.ecommerce.infrastructure.UserAccountRepository;
import com.homebrew.ecommerce.infrastructure.entity.UserAccount;
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
public class UserAccountService_IT {

    UserAccountService userAccountService;

    @Autowired
    UserAccountRepository repository;

    @BeforeEach
    void setUp() {
        userAccountService = new UserAccountServiceImpl(repository);
    }

    @Test
    public void ShouldSaveAddress() {
        var userAccountApi = UserAccountApi.builder()
                .email(UUID.randomUUID().toString())
                .password(UUID.randomUUID().toString())
                .customerApi(TestData.randomCustomerApi())
                .build();
        userAccountService.saveUserAccount(userAccountApi);

        var userAccount = repository.findAll().get(0);

        assertThat(userAccount)
                .extracting(
                        UserAccount::getEmail,
                        UserAccount::getPassword,
                        field -> field.getCustomer().getFirstName(),
                        field -> field.getCustomer().getLastName(),
                        field -> field.getCustomer().getSsn(),
                        field -> field.getCustomer().getAddress().getStreet(),
                        field -> field.getCustomer().getAddress().getNumber().toString(),
                        field -> field.getCustomer().getAddress().getZipCode().toString(),
                        field -> field.getCustomer().getAddress().getCity()
                ).containsExactly(
                        userAccountApi.email(),
                        userAccountApi.password(),
                        userAccountApi.customerApi().firstName(),
                        userAccountApi.customerApi().lastName(),
                        userAccountApi.customerApi().ssn(),
                        userAccountApi.customerApi().addressApi().street(),
                        userAccountApi.customerApi().addressApi().number().toString(),
                        userAccountApi.customerApi().addressApi().zipCode().toString(),
                        userAccountApi.customerApi().addressApi().city()
                );
    }
}
