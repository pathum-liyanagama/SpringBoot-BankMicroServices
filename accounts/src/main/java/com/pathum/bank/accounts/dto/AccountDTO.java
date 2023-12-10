package com.pathum.bank.accounts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDTO {

    private long accountNumber;

    @NotBlank
    private String accountType;

    @NotBlank(message = "Branch Address cannot be empty")
    private String branchAddress;

    private CustomerDTO customerDTO;
}
