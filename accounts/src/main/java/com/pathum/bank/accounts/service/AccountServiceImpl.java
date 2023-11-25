package com.pathum.bank.accounts.service;

import com.pathum.bank.accounts.dto.AccountDTO;
import com.pathum.bank.accounts.dto.CustomerDTO;
import com.pathum.bank.accounts.exception.ResourceNotFoundException;
import com.pathum.bank.accounts.mapper.AccountMapper;
import com.pathum.bank.accounts.mapper.CustomerMapper;
import com.pathum.bank.accounts.model.Account;
import com.pathum.bank.accounts.model.Customer;
import com.pathum.bank.accounts.repository.AccountRepository;
import com.pathum.bank.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    @Override
    public AccountDTO getAccountDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException("customer", "mobileNumber", mobileNumber)
                );

        Account account = accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("account", "customerId", customer.getCustomerId().toString())
                );

        AccountDTO accountDTO = AccountMapper.mapAccountToAccountsDto(account, new AccountDTO());
        accountDTO.setCustomerDTO(CustomerMapper.mapCustomerToCustomerDto(customer, new CustomerDTO()));

        return accountDTO;
    }
}
