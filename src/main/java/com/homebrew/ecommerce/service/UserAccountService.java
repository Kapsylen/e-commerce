package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.UserAccountApi;
import com.homebrew.ecommerce.domain.response.UserAccountId;

import java.util.List;

public interface UserAccountService {
    UserAccountApi getUserAccount(String id);
    UserAccountId saveUserAccount(UserAccountApi userAccountApi);
    void deleteUserAccount(String id);
    List<UserAccountApi> getAllUserAccounts();
}
