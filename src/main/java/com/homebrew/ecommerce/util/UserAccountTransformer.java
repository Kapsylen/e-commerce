package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.UserAccountApi;
import com.homebrew.ecommerce.infrastructure.entity.UserAccount;

import java.util.UUID;

public class UserAccountTransformer {

    public static UserAccountApi toUserAccountApi(UserAccount userAccount) {
       return UserAccountApi.builder()
                .email(userAccount.getEmail())
                .password(userAccount.getPassword())
                .customerApi(CustomerTransformer.toCustomerApi(userAccount.getCustomer()))
                .build();
    }

    public static UserAccount toUserAccount(UserAccountApi userAccountApi) {
        return new UserAccount(UUID.randomUUID().toString(), userAccountApi.email(), userAccountApi.password(), CustomerTransformer.toCustomer(userAccountApi.customerApi()));
    }
}
