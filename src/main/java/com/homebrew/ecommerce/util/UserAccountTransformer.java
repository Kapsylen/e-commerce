package com.homebrew.ecommerce.util;

import com.homebrew.ecommerce.domain.UserAccountApi;
import com.homebrew.ecommerce.infrastructure.entity.UserAccount;

public class UserAccountTransformer {

    public static UserAccountApi toUserAccountApi(UserAccount userAccount) {
       return UserAccountApi.builder()
                .userId(userAccount.getId())
                .email(userAccount.getEmail())
                .password(userAccount.getPassword())
                .build();
    }

    public static UserAccount toUserAccount(UserAccountApi userAccountApi) {
        return new UserAccount(userAccountApi.userId(), userAccountApi.email(), userAccountApi.password());
    }
}
