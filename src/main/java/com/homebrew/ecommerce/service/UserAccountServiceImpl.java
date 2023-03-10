package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.UserAccountApi;
import com.homebrew.ecommerce.domain.response.UserAccountId;
import com.homebrew.ecommerce.infrastructure.UserAccountRepository;
import com.homebrew.ecommerce.util.UserAccountTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.homebrew.ecommerce.util.UserAccountTransformer.toUserAccount;
import static com.homebrew.ecommerce.util.UserAccountTransformer.toUserAccountApi;


@Service
@AllArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository userAccountRepository;
    @Override
    public UserAccountApi getUserAccount(String id) {
        return toUserAccountApi(userAccountRepository.findById(id).get());
    }

    @Override
    public UserAccountId saveUserAccount(UserAccountApi userAccountApi) {
        return UserAccountId.builder().userAccountId(userAccountRepository.save(toUserAccount(userAccountApi)).getId()).build();
    }

    @Override
    public void deleteUserAccount(String id) {
        userAccountRepository.deleteById(id);
    }

    public List<UserAccountApi> getAllUserAccounts() {
        return userAccountRepository.findAll().stream().map(UserAccountTransformer::toUserAccountApi).toList();
    }
}
