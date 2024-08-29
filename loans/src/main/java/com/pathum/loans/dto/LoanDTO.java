package com.pathum.loans.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {

    private Long loanId;
    @NotBlank
    private String loanNumber;
    @NotBlank
    private String loanType;
    private int totalAmount;
    private int amountPaid;
    private int outstandingAmount;
}
