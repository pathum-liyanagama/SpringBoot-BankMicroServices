package com.pathum.bank.accounts.service;

import com.pathum.bank.accounts.dto.AccountDTO;

public interface IAccountService {

    AccountDTO getAccountDetails(String mobileNumber);

}
