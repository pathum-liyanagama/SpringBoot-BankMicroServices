package com.pathum.bank.accounts.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerDTO {

    @NotBlank(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "Length of name should be between 5 and 30 characters")
    private String name;

    @NotBlank
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountDTO accountDTO;
}
