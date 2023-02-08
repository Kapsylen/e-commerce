package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.UserAccountApi;

public interface UserAccountService {
    UserAccountApi getUserAccount(String id);
    void saveUserAccount(UserAccountApi userAccountApi);
    void deleteUserAccount(String id);
}
