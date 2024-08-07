package com.pathum.bank.accounts.repository;

import com.pathum.bank.accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByCustomerId(Long customerId);

    @Transactional // If any exception happen it will rollback all queries inside the caller method
    @Modifying // State that this custom method is going to modify existing data
    void deleteByCustomerId(Long customerId);

}
