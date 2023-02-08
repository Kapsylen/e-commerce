package com.homebrew.ecommerce.service;

import com.homebrew.ecommerce.domain.UserAccountApi;
import com.homebrew.ecommerce.infrastructure.UserAccountRepository;
import com.homebrew.ecommerce.util.UserAccountTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public void saveUserAccount(UserAccountApi userAccountApi) {
        userAccountRepository.save(UserAccountTransformer.toUserAccount(userAccountApi));
    }

    @Override
    public void deleteUserAccount(String id) {
        userAccountRepository.deleteById(id);
    }
}
