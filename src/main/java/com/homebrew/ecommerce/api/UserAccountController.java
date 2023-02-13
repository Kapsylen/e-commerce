package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.UserAccountApi;
import com.homebrew.ecommerce.domain.response.UserAccountId;
import com.homebrew.ecommerce.service.UserAccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserAccountController {

    private UserAccountServiceImpl userAccountService;

    @GetMapping("/useraccounts/{userAccountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserAccountApi getUserAccount(@PathVariable String userAccountId) {
        return userAccountService.getUserAccount(userAccountId);
    }

    @PostMapping("/useraccounts")
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserAccountId addUserAccount(@RequestBody UserAccountApi userAccountApi) {
        return userAccountService.saveUserAccount(userAccountApi);
    }

    @DeleteMapping("/useraccounts/{userAccountId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteUserAccount(@PathVariable String userAccountId) {
        userAccountService.deleteUserAccount(userAccountId);
    }

    @GetMapping("/useraccounts")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserAccountApi> getAllUserAccounts() {
        return userAccountService.getAllUserAccounts();
    }
}
