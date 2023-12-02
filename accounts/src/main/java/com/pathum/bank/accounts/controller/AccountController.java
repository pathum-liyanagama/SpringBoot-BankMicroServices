package com.pathum.bank.accounts.controller;

import com.pathum.bank.accounts.dto.AccountDTO;
import com.pathum.bank.accounts.dto.CustomerDTO;
import com.pathum.bank.accounts.dto.ResponseDTO;
import com.pathum.bank.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.pathum.bank.accounts.util.Constants.ACCOUNT_CREATED;

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

    @PostMapping()
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO){
        accountService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(HttpStatus.CREATED.value(), ACCOUNT_CREATED));
    }
}
