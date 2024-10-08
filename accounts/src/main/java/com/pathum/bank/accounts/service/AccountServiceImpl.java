package com.pathum.bank.accounts.service;

import com.pathum.bank.accounts.configs.AccountBuildConfigs;
import com.pathum.bank.accounts.dto.AccountDTO;
import com.pathum.bank.accounts.dto.CustomerDTO;
import com.pathum.bank.accounts.exception.CustomerAlreadyExistException;
import com.pathum.bank.accounts.exception.ResourceNotFoundException;
import com.pathum.bank.accounts.mapper.AccountMapper;
import com.pathum.bank.accounts.mapper.CustomerMapper;
import com.pathum.bank.accounts.model.Account;
import com.pathum.bank.accounts.model.Customer;
import com.pathum.bank.accounts.repository.AccountRepository;
import com.pathum.bank.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static com.pathum.bank.accounts.util.Constants.GALLE_BRANCH;
import static com.pathum.bank.accounts.util.Constants.SAVINGS;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private AccountBuildConfigs accountBuildConfigs;

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

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());

        if (customerOptional.isPresent()) {
            throw new CustomerAlreadyExistException("Customer with mobile number " + customerDTO.getMobileNumber() + " already exists.");
        }

        Customer customer = CustomerMapper.mapCustomerDtoToCustomer(customerDTO, new Customer());
        customerRepository.save(customer);

        Account newAccount = Account.builder()
                .accountNumber(generateAccountNumber())
                .customerId(customer.getCustomerId())
                .accountType(SAVINGS)
                .branchAddress(GALLE_BRANCH)
                .build();

        accountRepository.save(newAccount);
    }

    public void updateAccount(Long accountNumber, AccountDTO accountDTO) {
        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account", "accountNumber", String.valueOf(accountNumber))
                );

        AccountMapper.mapAccountDtoToAccount(accountDTO, account);
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long accountNumber) {
        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account", "accountNumber", String.valueOf(accountNumber))
                );

        accountRepository.deleteById(account.getAccountNumber());
    }

    @Override
    public void deleteAccountByMobileNumber(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException("customer", "mobileNumber", mobileNumber)
                );

        accountRepository.deleteByCustomerId(customer.getCustomerId());
    }

    @Override
    public Map<String, Object> getBuildDetails() throws IllegalAccessException {
        Map<String, Object> buildInfo = new HashMap<>();

        Field[] fields = accountBuildConfigs.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // To access private fields
            buildInfo.put(field.getName(), field.get(accountBuildConfigs));
        }
        return buildInfo;
    }

    private Long generateAccountNumber() {
        int accNumLength = 10;
        long timestamp = Instant.now().toEpochMilli();

        Random random = new Random();
        int randomComponent = random.nextInt(900) + 100; // ensures a 3-digit number

        String accountNumber = timestamp + String.valueOf(randomComponent);

        // Ensure the length is exactly 10 digits
        if (accountNumber.length() > accNumLength) {
            accountNumber = accountNumber.substring(0, accNumLength);
        } else if (accountNumber.length() < accNumLength) {
            // Pad with zeros if necessary
            accountNumber = "1000000000".substring(0, 10 - accountNumber.length()) + accountNumber;
        }

        return Long.parseLong(accountNumber);
    }
}
