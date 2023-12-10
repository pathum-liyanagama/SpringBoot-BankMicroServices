package com.pathum.bank.accounts.controller;

import com.pathum.bank.accounts.dto.AccountDTO;
import com.pathum.bank.accounts.dto.CustomerDTO;
import com.pathum.bank.accounts.dto.ResponseDTO;
import com.pathum.bank.accounts.service.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.pathum.bank.accounts.util.Constants.*;

@RestController
@RequestMapping(path = "/api/v1/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor // Auto-wiring won't happen with default constructor
@Validated
public class AccountController {

    private IAccountService accountService;

    @GetMapping()
    public ResponseEntity<AccountDTO> getAccount(
            @NotBlank
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
            @RequestParam
            String mobileNumber) {
        return ResponseEntity
                .ok()
                .body(accountService.getAccountDetails(mobileNumber));
    }

    @PostMapping()
    public ResponseEntity<ResponseDTO> createAccount(
            @Valid
            @RequestBody
            CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(HttpStatus.CREATED.value(), ACCOUNT_CREATED));
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<ResponseDTO> updateAccount(
            @NotNull
            @PathVariable
            Long accountNumber,
            @Valid
            @RequestBody
            AccountDTO accountDTO) {
        accountService.updateAccount(accountNumber, accountDTO);
        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.NO_CONTENT.value(), ACCOUNT_UPDATED));
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<ResponseDTO> deleteAccount(
            @NotNull
            @PathVariable
            Long accountNumber) {
        accountService.deleteAccount(accountNumber);
        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.NO_CONTENT.value(), ACCOUNT_DELETED));
    }

    @DeleteMapping()
    public ResponseEntity<ResponseDTO> deleteAccountByMobileNumber(
            @NotBlank
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
            @RequestParam
            String mobileNumber) {
        accountService.deleteAccountByMobileNumber(mobileNumber);
        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.NO_CONTENT.value(), ACCOUNT_DELETED));
    }

}
