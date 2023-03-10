package com.homebrew.ecommerce.infrastructure;

import com.homebrew.ecommerce.infrastructure.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
