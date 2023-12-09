package com.pathum.bank.accounts.mapper;

import com.pathum.bank.accounts.dto.AccountDTO;
import com.pathum.bank.accounts.model.Account;

public class AccountMapper {

    public static AccountDTO mapAccountToAccountsDto(Account account, AccountDTO accountDTO){
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setBranchAddress(account.getBranchAddress());
        return accountDTO;
    }

    public static Account mapAccountDtoToAccount(AccountDTO accountDTO, Account account){
        account.setAccountType(accountDTO.getAccountType());
        account.setBranchAddress(accountDTO.getBranchAddress());
        return account;
    }
}
