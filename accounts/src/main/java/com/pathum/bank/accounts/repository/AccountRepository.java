package com.pathum.bank.accounts.repository;

import com.pathum.bank.accounts.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByCustomerId(Long customerId);

}
