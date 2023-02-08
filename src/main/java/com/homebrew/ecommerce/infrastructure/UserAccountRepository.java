package com.homebrew.ecommerce.infrastructure;

import com.homebrew.ecommerce.infrastructure.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, String> {
}
