package com.homebrew.ecommerce.api;

import com.homebrew.ecommerce.domain.UserAccountApi;
import com.homebrew.ecommerce.service.UserAccountServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountController {

    private UserAccountServiceImpl userAccountService;

    @GetMapping("/useraccount/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserAccountApi getUserAccount(@PathVariable String id) {
        return userAccountService.getUserAccount(id);
    }

    @PostMapping("/useraccounts")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addUserAccount(@RequestBody UserAccountApi userAccountApi) {
        userAccountService.saveUserAccount(userAccountApi);
    }

    @DeleteMapping("/useraccount/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteUserAccount(@PathVariable String id) {
        userAccountService.deleteUserAccount(id);
    }
}
