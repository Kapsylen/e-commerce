package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.AddressApi;
import com.homebrew.ecommerce.domain.UserAccountApi;
import com.homebrew.ecommerce.infrastructure.UserAccountRepository;
import com.homebrew.ecommerce.util.TestData;
import com.homebrew.ecommerce.util.UserAccountTransformer;
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

        var userAccount = repository.findAll();
        assertThat(userAccount).isNotNull();
    }
}
