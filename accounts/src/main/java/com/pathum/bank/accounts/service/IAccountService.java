package com.pathum.bank.accounts.service;

import com.pathum.bank.accounts.dto.AccountDTO;
import com.pathum.bank.accounts.dto.CustomerDTO;

public interface IAccountService {

    AccountDTO getAccountDetails(String mobileNumber);


    void createAccount(CustomerDTO customerDTO);
}
