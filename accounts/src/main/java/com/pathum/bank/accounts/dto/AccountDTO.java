package com.pathum.bank.accounts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDTO {

    @NotBlank
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    private long accountNumber;

    @NotBlank
    private String accountType;

    @NotBlank(message = "Branch Address cannot be empty")
    private String branchAddress;

    private CustomerDTO customerDTO;
}
