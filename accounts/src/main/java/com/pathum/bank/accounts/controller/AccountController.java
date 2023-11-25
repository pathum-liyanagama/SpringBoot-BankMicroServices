package com.pathum.bank.accounts.controller;

import com.pathum.bank.accounts.dto.AccountDTO;
import com.pathum.bank.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor // Auto-wiring won't happen with default constructor
public class AccountController {

    private IAccountService accountService;

    @GetMapping()
    public ResponseEntity<AccountDTO> getAccount(@RequestParam String mobileNumber) {
        return ResponseEntity
                .ok()
                .body(accountService.getAccountDetails(mobileNumber));
    }
}
